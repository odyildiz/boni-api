package com.bonigraphy.boni_api.integration.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/redeploy")
public class RedeployController {

    @GetMapping("/boni-ui")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> buildUI() {
        try {
            // Get the current working directory
            String currentPath = System.getProperty("user.dir");
            // Navigate to parent directory and then to boni-ui
            File uiDirectory = new File(currentPath).getParentFile();
            File targetDirectory = new File(uiDirectory, "boni-ui");

            // Create process builder for npm run build
            ProcessBuilder processBuilder = new ProcessBuilder("npm", "run", "deploy");
            processBuilder.directory(targetDirectory);

            // Redirect error stream to output stream
            processBuilder.redirectErrorStream(true);

            // Start the process
            Process process = processBuilder.start();

            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                return ResponseEntity.ok("UI build completed successfully\n" + output);
            } else {
                return ResponseEntity.internalServerError()
                        .body("UI build failed with exit code " + exitCode + "\n" + output);
            }

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error during UI build: " + e.getMessage());
        }
    }
}
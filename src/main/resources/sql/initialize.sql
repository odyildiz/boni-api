CREATE TABLE IF NOT EXISTS employee
(
    id        SERIAL PRIMARY KEY,
    email     VARCHAR(255) UNIQUE NOT NULL,
    password  VARCHAR(255)        NOT NULL,
    full_name VARCHAR(255)        NOT NULL,
    role      VARCHAR(50) DEFAULT 'ADMIN'
);

-- Create menu_category table
CREATE TABLE menu_category
(
    id      SERIAL PRIMARY KEY,
    slug    VARCHAR(255) NOT NULL UNIQUE,
    name_tr VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL
);

-- Create menu_item table
CREATE TABLE menu_item
(
    id          SERIAL PRIMARY KEY,
    slug        VARCHAR(255)     NOT NULL UNIQUE,
    name_tr     VARCHAR(255)     NOT NULL,
    name_en     VARCHAR(255)     NOT NULL,
    price1      DOUBLE PRECISION NOT NULL,
    price2      DOUBLE PRECISION,
    category_id BIGINT           NOT NULL,
    FOREIGN KEY (category_id) REFERENCES menu_category (id)
);

-- Create gallery photo table
CREATE TABLE photo (
                       id SERIAL PRIMARY KEY,
                       image_url VARCHAR(255) NOT NULL,
                       title_tr VARCHAR(255) NOT NULL,
                       title_en VARCHAR(255) NOT NULL,
                       description_tr TEXT NOT NULL,
                       description_en TEXT NOT NULL
);

---- sample data --------

INSERT INTO public.employee (email, password, full_name)
VALUES ('ozencyldz@gmail.com', '$2a$10$QceY7PKMl/3y5QePzS6bBehKZsxiEo1vTsY/8yDMmlTNN0FgRoSTG', 'Özenç Yıldız');

-- Menu Categories
INSERT INTO menu_category (slug, name_tr, name_en)
VALUES ('coffee', 'Kahve', 'Coffee'),
       ('cold-coffee', 'Soğuk Kahve', 'Cold Coffee'),
       ('drinks', 'İçecekler', 'Drinks'),
       ('cold-drinks', 'Soğuk İçecekler', 'Cold Drinks'),
       ('snacks', 'Atıştırmalıklar', 'Snacks'),
       ('desserts', 'Tatlı', 'Desserts'),
       ('extra', 'Ekstra', 'Extra');

-- Coffee Items
INSERT INTO menu_item (category_id, slug, name_tr, name_en, price1, price2)
VALUES ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'espresso-single', 'Espresso (Single)',
        'Espresso (Single)', 80.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'espresso-double', 'Espresso (Double)',
        'Espresso (Double)', 90.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'lungo', 'Lungo', 'Lungo', 80.00, 100.00),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'americano', 'Americano', 'Americano', 100.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'caramel-latte', 'Caramel Latte', 'Caramel Latte', 130.00,
        null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'vanilla-latte', 'Vanilla Latte', 'Vanilla Latte', 130.00,
        null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'cafe-latte', 'Cafe Latte', 'Cafe Latte', 120.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'cappuccino', 'Cappuccino', 'Cappuccino', 120.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'flat-white', 'Flat White', 'Flat White', 120.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'cortado', 'Cortado', 'Cortado', 115.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'cafe-miel', 'Cafe Miel (bal + tarçın)',
        'Cafe Miel (honey + cinnamon)', 140.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'mocha', 'Mocha', 'Mocha', 130.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'white-chocolate-mocha', 'White Chocolate Mocha',
        'White Chocolate Mocha', 130.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'filter-coffee', 'Filtre Kahve', 'Filter Coffee', 100.00,
        null),
       ((SELECT id FROM menu_category WHERE slug = 'coffee'), 'turkish-coffee', 'Türk Kahvesi', 'Turkish Coffee', 75.00,
        90.00);

-- Cold Coffee Items
INSERT INTO menu_item (category_id, slug, name_tr, name_en, price1, price2)
VALUES ((SELECT id FROM menu_category WHERE slug = 'cold-coffee'), 'iced-americano', 'Buzlu Americano',
        'Iced Americano', 120.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-coffee'), 'iced-latte', 'Buzlu Latte', 'Iced Latte', 130.00,
        null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-coffee'), 'iced-flat-white', 'Buzlu Flat White',
        'Iced Flat White', 130.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-coffee'), 'iced-mocha', 'Buzlu Mocha', 'Iced Mocha', 135.00,
        null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-coffee'), 'iced-white-mocha', 'Buzlu White Mocha',
        'Iced White Mocha', 135.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-coffee'), 'affogato',
        'Affogato (Vanilyalı Dondurma + Espresso)', 'Affogato (Vanilla Ice Cream + Espresso)', 140.00, null);

-- Extra Items
INSERT INTO menu_item (category_id, slug, name_tr, name_en, price1, price2)
VALUES ((SELECT id FROM menu_category WHERE slug = 'extra'), 'shot', 'Shot', 'Shot', 30.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'extra'), 'syrup', 'Şurup', 'Syrup', 15.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'extra'), 'milk', 'Süt', 'Milk', 15.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'extra'), 'ice-cream', 'Dondurma', 'Ice Cream', 30.00, null);

-- Drinks Items
INSERT INTO menu_item (category_id, slug, name_tr, name_en, price1, price2)
VALUES ((SELECT id FROM menu_category WHERE slug = 'drinks'), 'honey-milk', 'Ballı Süt', 'Honey Milk', 100.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'drinks'), 'salep', 'Salep', 'Salep', 125.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'drinks'), 'hot-chocolate', 'Sıcak Çikolata', 'Hot Chocolate',
        130.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'drinks'), 'tea', 'Çay', 'Tea', 30.00, 50.00),
       ((SELECT id FROM menu_category WHERE slug = 'drinks'), 'herbal-tea',
        'Bitki Çayı (Ada, Melisa, Yeşil, Ihlamur, Papatya, Kış Çayı)',
        'Herbal Tea (Sage, Lemon Balm, Green, Linden, Daisy, Winter)', 110.00, null);

-- Cold Drinks Items
INSERT INTO menu_item (category_id, slug, name_tr, name_en, price1, price2)
VALUES ((SELECT id FROM menu_category WHERE slug = 'cold-drinks'), 'sparkling-water', 'Maden Suyu', 'Sparkling Water',
        50.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-drinks'), 'churchill', 'Churchill', 'Churchill', 80.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-drinks'), 'fizzy-drink', 'Gazoz', 'Fizzy Drink', 80.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-drinks'), 'cold-chocolate', 'Soğuk Çikolata', 'Cold Chocolate',
        135.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-drinks'), 'orange-juice', 'Portakal Suyu', 'Orange Juice',
        120.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'cold-drinks'), 'water', 'Su', 'Water', 30.00, null);

-- Snacks Items
INSERT INTO menu_item (category_id, slug, name_tr, name_en, price1, price2)
VALUES ((SELECT id FROM menu_category WHERE slug = 'snacks'), 'boni-toast',
        'Boni Tost (Balkan Sos, Ezine Peyniri, Kaşar Peyniri)',
        'Boni Toast (Balkan Sauce, Ezine Cheese, Kashar Cheese)', 190.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'snacks'), 'white-cheese-tomato-toast',
        'Beyaz Peynirli Domatesli Tost (Ezine Peyniri, Domates, Zeytin Yağı, Kekik)',
        'White Cheese with Tomato Toast (Ezine Cheese, Tomato, Olive Oil, Thyme)', 190.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'snacks'), 'kashar-cheese-toast', 'Kaşar Peyniri',
        'Kashar Cheese Toast', 170.00, null);

-- Desserts Items
INSERT INTO menu_item (category_id, slug, name_tr, name_en, price1, price2)
VALUES ((SELECT id FROM menu_category WHERE slug = 'desserts'), 'brownie-ice-cream', 'Brownie + Dondurma',
        'Brownie + Ice Cream', 190.00, null),
       ((SELECT id FROM menu_category WHERE slug = 'desserts'), 'chocolate-cookie', 'Çikolatalı Kurabiye',
        'Chocolate Cookie', 80.00, null);

-- Gallery Photos
INSERT INTO photo (image_url, title_tr, title_en, description_tr, description_en)
VALUES
    ('https://images.unsplash.com/photo-1470115636492-6d2b56f9146d',
     'Şehir Manzarası',
     'Urban Landscape',
     'Altın saatte şehir siluetinin muhteşem bir görünümü, modern mimariyi ve şehir planlamasını en iyi şekilde sergiliyor.',
     'A stunning view of the city skyline at golden hour, showcasing modern architecture and urban planning at its finest.'),

    ('https://images.unsplash.com/photo-1470093851219-69951fcbb533',
     'Sokak Yaşamı',
     'Street Life',
     'Farklı kültürlerin ve günlük yaşamın güzel bir kaos içinde kesiştiği şehir sokaklarının canlı enerjisini yakalıyor.',
     'Capturing the vibrant energy of city streets, where diverse cultures and daily life intersect in beautiful chaos.'),

    ('https://images.unsplash.com/photo-1447752875215-b2761acb3c5d',
     'Doğanın Yolu',
     'Nature''s Path',
     'Eski ağaçların arasından kıvrılan huzurlu bir orman patikası, gezginleri doğanın gizli hazinelerini keşfetmeye davet ediyor.',
     'A serene forest trail winding through ancient trees, inviting wanderers to explore nature''s hidden treasures.'),

    ('https://images.unsplash.com/photo-1472214103451-9374bd1c798e',
     'Dağ Manzarası',
     'Mountain View',
     'Sabah sisini delen görkemli dağ zirveleri, doğal güzelliğin nefes kesen bir panoramasını oluşturuyor.',
     'Majestic mountain peaks piercing through morning mist, creating a breathtaking panorama of natural beauty.'),

    ('https://images.unsplash.com/photo-1470093851219-69951fcbb533',
     'Şehir Geceleri',
     'City Nights',
     'Şehir geceleri ışıkların senfonisiyle canlanıyor, hiç uyumayan büyülü bir kent manzarası yaratıyor.',
     'The city comes alive at night with a symphony of lights, creating a magical urban landscape that never sleeps.'),

    ('https://images.unsplash.com/photo-1447752875215-b2761acb3c5d',
     'Orman Yürüyüşü',
     'Forest Walk',
     'Güneş ışığının ağaç tepelerinden esrarengiz ışınlar halinde süzüldüğü ormanın kalbinde huzurlu bir yolculuk.',
     'A peaceful journey through the heart of the forest, where sunlight filters through the canopy in ethereal rays.');
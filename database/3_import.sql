INSERT INTO bmx.role (id, name) VALUES (default, 'admin');
INSERT INTO bmx.role (id, name) VALUES (default, 'customer');

INSERT INTO bmx."user" (id, role_id, username, password, status, email) VALUES (default, 1, 'admin', '123', 'A', 'admin@bmx.com');
INSERT INTO bmx."user" (id, role_id, username, password, status, email) VALUES (default, 2, 'user', '123', 'A', 'customer@bmx.com');

INSERT INTO bmx.location_type (id, name, color_code) VALUES (default, 'Skatepark', '#32CD32');
INSERT INTO bmx.location_type (id, name, color_code) VALUES (default, 'Pumptrack', '#1E90FF');
INSERT INTO bmx.location_type (id, name, color_code) VALUES (default, 'Spot', '#B22222');


INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Harju maakond', 7, 24.753574, 59.436962);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Hiiu maakond', 7, 22.790000, 58.900000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Ida-Viru maakond', 7, 27.266000, 59.360000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Jõgeva maakond', 7, 26.383000, 58.733000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Järva maakond', 7, 25.570000, 58.883000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Lääne maakond', 7, 23.537053, 58.948249);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Lääne-Viru maakond', 7, 26.350000, 59.350000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Põlva maakond', 7, 27.054866, 58.053746);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Pärnu maakond', 7, 24.500000, 58.380000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Rapla maakond', 7, 24.867000, 59.000000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Saare maakond', 7, 22.300000, 58.250000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Tartu maakond', 7, 26.728493, 58.378000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Valga maakond', 7, 26.020000, 57.780000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Viljandi maakond', 7, 25.600000, 58.367000);
INSERT INTO bmx.county (id, name, zoom_level, lng, lat) VALUES (default, 'Võru maakond', 7, 27.030000, 57.850000);

INSERT INTO bmx.tag (id, name, status) VALUES (default, 'algaja', 'A');
INSERT INTO bmx.tag (id, name, status) VALUES (default, 'kesktase', 'A');
INSERT INTO bmx.tag (id, name, status) VALUES (default, 'ekspert', 'A');
INSERT INTO bmx.tag (id, name, status) VALUES (default, 'pro', 'A');


INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 1, 6, 'Haapsalu Skatepark', 'Lihula mnt 10, Haapsalu', 23.541411, 58.936361, 'Suur park ja lõbus park, aga praeguseks juba amortiseerunud. Vineeris on auke.', 'P', 0.0, '2025-12-11 18:31:36.105150');
INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 1, 1, 'Kanutiaia rulapark', 'Aia tn 12, 10111 Tallinn', 24.752162, 59.439133, 'Tüüpiline Rhino Parks-i konstruktsioon. Libe ja mitte eriti fun.', 'P', 0.0, '2025-12-11 18:36:41.517111');
INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 1, 12, 'Tartu Tähtvere Skatepark', 'F. Tuglase tn, 51006 Tartu', 26.698958, 58.387545, 'Suur striidile orienteeritud skatepark. Ruumi on kõvasti. On ka parajalt sügav bowli osa, kus kihutada saab.', 'P', 0.0, '2025-12-11 18:46:54.196243');
INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 2, 12, 'Tartu Tähtvere Pumptrack', 'F. Tuglase tn, 51006 Tartu', 26.699637, 58.387232, 'Kahe hüppega asjalik pumptrack.', 'P', 0.0, '2025-12-11 19:00:00.866132');
INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 3, 1, 'Skoone Spot', 'Suurtüki tn 12, 10133 Tallinn', 24.746599, 59.442888, 'Reilid ja kickerid.', 'P', 0.0, '2025-12-11 19:35:05.696771');
INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 3, 5, 'fsjytjhsd', 'fsgsgfjsb', 25.575829, 58.887962, 'dbgbgdf', 'P', 0.0, '2025-12-11 19:38:31.871888');
INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 1, 2, 'Kärdla Skatepark', 'Põllu tn 27, Kärdla, 92414 Hiiu maakond', 22.757610, 58.997309, 'Madalad obstaaklid, pigem mõeldud päris algajatele või siis tõukeratasele ja ruladele.', 'P', 0.0, '2025-12-11 21:33:07.224710');
INSERT INTO bmx.location (id, user_id, location_type_id, county_id, name, address, lng, lat, description, status, average_rating, created_at) VALUES (default, 2, 2, 2, 'Viscosa Kultuuritehase Pumptrack', 'Jäätme, Kõrgessaare, 92201 Hiiu maakond', 22.469235, 58.980669, 'Lihtsam pumptrack otse kultuuri südames.', 'P', 0.0, '2025-12-11 22:05:42.898798');

INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 6, 3);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 1, 4);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 2, 1);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 3, 1);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 3, 3);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 3, 2);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 4, 1);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 4, 2);
INSERT INTO bmx.location_tag (id, location_id, tag_id) VALUES (default, 5, 4);

INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 1, 4, '2025-12-09 22:26:27.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 4, 5, '2025-12-08 23:27:53.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 2, 2, '2025-12-11 22:28:36.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 3, 3, '2025-12-01 22:29:02.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 5, 1, '2025-12-12 22:29:25.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 1, 3, '2025-12-11 22:30:43.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 4, 2, '2025-12-11 22:30:44.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 2, 1, '2025-12-11 22:30:45.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 3, 4, '2025-12-11 22:30:46.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 5, 5, '2025-12-11 22:30:47.000000');




INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 1, 4, '2025-12-09 22:26:27.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 4, 5, '2025-12-08 23:27:53.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 2, 2, '2025-12-11 22:28:36.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 3, 3, '2025-12-01 22:29:02.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 5, 1, '2025-12-12 22:29:25.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 1, 3, '2025-12-11 22:30:43.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 4, 2, '2025-12-11 22:30:44.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 2, 1, '2025-12-11 22:30:45.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 3, 4, '2025-12-11 22:30:46.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 5, 5, '2025-12-11 22:30:47.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 1, 4, '2025-12-12 00:14:27.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 2, 5, '2025-12-12 00:14:29.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 3, 5, '2025-12-12 00:14:30.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 4, 4, '2025-12-12 00:14:31.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 5, 4, '2025-12-12 00:14:31.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 7, 5, '2025-12-12 00:14:32.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 8, 5, '2025-12-12 00:14:32.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 1, 3, '2025-12-12 00:14:33.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 2, 1, '2025-12-12 00:14:33.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 3, 3, '2025-12-12 00:14:34.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 4, 2, '2025-12-12 00:14:34.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 1, 5, 1, '2025-12-12 00:14:35.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 7, 4, '2025-12-12 00:14:36.000000');
INSERT INTO bmx.location_rating (id, user_id, location_id, rating, created_at) VALUES (default, 2, 8, 1, '2025-12-12 00:14:36.000000');

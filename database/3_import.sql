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

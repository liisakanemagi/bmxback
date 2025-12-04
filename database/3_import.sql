INSERT INTO bmx.role (id, name) VALUES (default, 'admin');
INSERT INTO bmx.role (id, name) VALUES (default, 'customer');

INSERT INTO bmx."user" (id, role_id, username, password, status, email) VALUES (default, 1, 'admin', '123', 'A', 'admin@bmx.com');
INSERT INTO bmx."user" (id, role_id, username, password, status, email) VALUES (default, 2, 'user', '123', 'A', 'customer@bmx.com');

INSERT INTO bmx.location_type (id, name, color_code) VALUES (default, 'Skatepark', '#32CD32');
INSERT INTO bmx.location_type (id, name, color_code) VALUES (default, 'Pumptrack', '#1E90FF');
INSERT INTO bmx.location_type (id, name, color_code) VALUES (default, 'Spot', '#B22222');

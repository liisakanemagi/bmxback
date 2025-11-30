INSERT INTO bmx.role (id, name) VALUES (default, 'admin');
INSERT INTO bmx.role (id, name) VALUES (default, 'customer');

INSERT INTO bmx."user" (id, role_id, name, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO bmx."user" (id, role_id, name, password, status) VALUES (default, 2, 'user', '123', 'A');


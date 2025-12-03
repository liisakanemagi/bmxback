INSERT INTO bmx.role (id, name) VALUES (default, 'admin');
INSERT INTO bmx.role (id, name) VALUES (default, 'customer');

INSERT INTO bmx."user" (id, role_id, name, password, status, email) VALUES (default, 1, 'admin', '123', 'A', null);
INSERT INTO bmx."user" (id, role_id, name, password, status, email) VALUES (default, 2, 'user', '123', 'A', null);

INSERT INTO roles (name) VALUES
  ('ROLE_ADMIN'),
  ('ROLE_USER');

INSERT INTO users (name,surname,username,password) VALUES
  ('Konrad', 'Kozłowski', 'Kondi', '123');

INSERT INTO role_per (per_id, role_id) VALUES
  (1,1),
  (1,2);
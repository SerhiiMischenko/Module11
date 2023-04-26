INSERT INTO Client (name) VALUES
  ('John Smith'),
  ('Mary Johnson'),
  ('Robert Lee'),
  ('Emily Davis'),
  ('William Brown'),
  ('Sarah Jackson'),
  ('Michael Wilson'),
  ('Jessica Garcia'),
  ('David Rodriguez'),
  ('Amanda Hernandez');

INSERT INTO Planet (id, name) VALUES
  ('EARTH', 'Earth'),
  ('MARS', 'Mars'),
  ('VENUS', 'Venus'),
  ('JUPITER', 'Jupiter'),
  ('SATURN', 'Saturn');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id)
VALUES
  (1, 'EARTH', 'MARS'),
  (2, 'MARS', 'EARTH'),
  (3, 'EARTH', 'VENUS'),
  (4, 'VENUS', 'JUPITER'),
  (5, 'JUPITER', 'SATURN'),
  (6, 'SATURN', 'EARTH'),
  (7, 'MARS', 'VENUS'),
  (8, 'VENUS', 'MARS'),
  (9, 'JUPITER', 'MARS'),
  (10, 'SATURN', 'VENUS');
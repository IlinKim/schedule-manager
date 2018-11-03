INSERT INTO rooms VALUES (1, now(), now(), '회의실1');
INSERT INTO rooms VALUES (2, now(), now(), '회의실2');
INSERT INTO rooms VALUES (3, now(), now(), '회의실3');
INSERT INTO rooms VALUES (4, now(), now(), '회의실4');

INSERT INTO time_lines (id, start, end) VALUES (1, '00:00:00', '00:30:00');
INSERT INTO time_lines (id, start, end) VALUES (2, '00:30:00', '01:00:00');
INSERT INTO time_lines (id, start, end) VALUES (3, '01:00:00', '01:30:00');

INSERT INTO reservation_groups (id, repeat_count, created_at, updated_at)
VALUES (1, 0, now(), now());

INSERT INTO reservations (id, title, description, user_name, reservation_group_id, created_at, updated_at)
VALUES (1, 'test 예약', 'test desc', 'Kaka', 1, now(), now());

INSERT INTO reservation_cells (id, room_id, reservation_id, date, time_line_id, created_at, updated_at)
VALUES (1, 2, 1, '2018-11-03', 1, now(), now());
INSERT INTO reservation_cells (id, room_id, reservation_id, date, time_line_id, created_at, updated_at)
VALUES (2, 2, 1, '2018-11-03', 2, now(), now());
INSERT INTO reservation_cells (id, room_id, reservation_id, date, time_line_id, created_at, updated_at)
VALUES (3, 2, 1, '2018-11-03', 3, now(), now());

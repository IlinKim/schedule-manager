INSERT INTO rooms (id, created_at, updated_at, room_name, room_color) VALUES (1, now(), now(), '회의실1', '#c72525');
INSERT INTO rooms (id, created_at, updated_at, room_name, room_color) VALUES (2, now(), now(), '회의실2', '#634e4e');
INSERT INTO rooms (id, created_at, updated_at, room_name, room_color) VALUES (3, now(), now(), '회의실3', '#262E89');
INSERT INTO rooms (id, created_at, updated_at, room_name, room_color) VALUES (4, now(), now(), '회의실4', '#696C85');

INSERT INTO time_lines (id, start, end) VALUES (1, '00:00:00', '00:30:00');
INSERT INTO time_lines (id, start, end) VALUES (2, '00:30:00', '01:00:00');
INSERT INTO time_lines (id, start, end) VALUES (3, '01:00:00', '01:30:00');
INSERT INTO time_lines (id, start, end) VALUES (4, '01:30:00', '02:00:00');
INSERT INTO time_lines (id, start, end) VALUES (5, '02:00:00', '02:30:00');
INSERT INTO time_lines (id, start, end) VALUES (6, '02:30:00', '03:00:00');
INSERT INTO time_lines (id, start, end) VALUES (7, '03:00:00', '03:30:00');
INSERT INTO time_lines (id, start, end) VALUES (8, '03:30:00', '04:00:00');
INSERT INTO time_lines (id, start, end) VALUES (9, '04:00:00', '04:30:00');
INSERT INTO time_lines (id, start, end) VALUES (10, '04:30:00', '05:00:00');
INSERT INTO time_lines (id, start, end) VALUES (11, '05:00:00', '05:30:00');
INSERT INTO time_lines (id, start, end) VALUES (12, '05:30:00', '06:00:00');
INSERT INTO time_lines (id, start, end) VALUES (13, '06:00:00', '06:30:00');
INSERT INTO time_lines (id, start, end) VALUES (14, '06:30:00', '07:00:00');
INSERT INTO time_lines (id, start, end) VALUES (15, '07:00:00', '07:30:00');
INSERT INTO time_lines (id, start, end) VALUES (16, '07:30:00', '08:00:00');
INSERT INTO time_lines (id, start, end) VALUES (17, '08:00:00', '08:30:00');
INSERT INTO time_lines (id, start, end) VALUES (18, '08:30:00', '09:00:00');
INSERT INTO time_lines (id, start, end) VALUES (19, '09:00:00', '09:30:00');
INSERT INTO time_lines (id, start, end) VALUES (20, '09:30:00', '10:00:00');
INSERT INTO time_lines (id, start, end) VALUES (21, '10:00:00', '10:30:00');
INSERT INTO time_lines (id, start, end) VALUES (22, '10:30:00', '11:00:00');
INSERT INTO time_lines (id, start, end) VALUES (23, '11:00:00', '11:30:00');
INSERT INTO time_lines (id, start, end) VALUES (24, '11:30:00', '12:00:00');
INSERT INTO time_lines (id, start, end) VALUES (25, '12:00:00', '12:30:00');
INSERT INTO time_lines (id, start, end) VALUES (26, '12:30:00', '13:00:00');
INSERT INTO time_lines (id, start, end) VALUES (27, '13:00:00', '13:30:00');
INSERT INTO time_lines (id, start, end) VALUES (28, '13:30:00', '14:00:00');
INSERT INTO time_lines (id, start, end) VALUES (29, '14:00:00', '14:30:00');
INSERT INTO time_lines (id, start, end) VALUES (30, '14:30:00', '15:00:00');
INSERT INTO time_lines (id, start, end) VALUES (31, '15:00:00', '15:30:00');
INSERT INTO time_lines (id, start, end) VALUES (32, '15:30:00', '16:00:00');
INSERT INTO time_lines (id, start, end) VALUES (33, '16:00:00', '16:30:00');
INSERT INTO time_lines (id, start, end) VALUES (34, '16:30:00', '17:00:00');
INSERT INTO time_lines (id, start, end) VALUES (35, '17:00:00', '17:30:00');
INSERT INTO time_lines (id, start, end) VALUES (36, '17:30:00', '18:00:00');
INSERT INTO time_lines (id, start, end) VALUES (37, '18:00:00', '18:30:00');
INSERT INTO time_lines (id, start, end) VALUES (38, '18:30:00', '19:00:00');
INSERT INTO time_lines (id, start, end) VALUES (39, '19:00:00', '19:30:00');
INSERT INTO time_lines (id, start, end) VALUES (40, '19:30:00', '20:00:00');
INSERT INTO time_lines (id, start, end) VALUES (41, '20:00:00', '20:30:00');
INSERT INTO time_lines (id, start, end) VALUES (42, '20:30:00', '21:00:00');
INSERT INTO time_lines (id, start, end) VALUES (43, '21:00:00', '21:30:00');
INSERT INTO time_lines (id, start, end) VALUES (44, '21:30:00', '22:00:00');
INSERT INTO time_lines (id, start, end) VALUES (45, '22:00:00', '22:30:00');
INSERT INTO time_lines (id, start, end) VALUES (46, '22:30:00', '23:00:00');
INSERT INTO time_lines (id, start, end) VALUES (47, '23:00:00', '23:30:00');
INSERT INTO time_lines (id, start, end) VALUES (48, '23:30:00', '00:00:00');


INSERT INTO reservation_groups (id, created_at, updated_at)
VALUES (1, now(), now());

INSERT INTO reservations (id, title, user_name, reservation_group_id, created_at, updated_at)
VALUES (1, 'test 예약', 'Kaka', 1, now(), now());

INSERT INTO reservation_cells (id, room_id, reservation_id, date, time_line_id, created_at, updated_at)
VALUES (1, 2, 1, '2018-11-03', 1, now(), now());
INSERT INTO reservation_cells (id, room_id, reservation_id, date, time_line_id, created_at, updated_at)
VALUES (2, 2, 1, '2018-11-03', 2, now(), now());
INSERT INTO reservation_cells (id, room_id, reservation_id, date, time_line_id, created_at, updated_at)
VALUES (3, 2, 1, '2018-11-03', 3, now(), now());

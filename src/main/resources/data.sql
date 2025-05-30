INSERT INTO user (email, first_name, last_name, password) VALUES
                                                    ('a.nowak@example.com', 'Adam', 'Nowak', '$2a$10$sTfqHyu2cpDjn.9.Vpk2n.hJ9Jca1B.0qft4gCm1AtNBfei1kQ7hm'),
                                                    ('ak@example.com', 'Anna', 'Kowalska', '$2a$10$6dzkNaAzCv7jjJ1H94x1h.KlQi3MdjcHPL2AFIkqAYuRPRWtqBD3O');
-- testuser11
-- testuser22


INSERT INTO car (fuel_type, make, model, registration_number, user_id) VALUES
                                                                           ('Diesel', 'Toyota', 'Corolla', 'WE56TY9', 1),
                                                                           ('Petrol', 'Ford', 'Focus', 'WE5DB33', 1),
                                                                           ('LPG', 'Volkswagen', 'Golf', 'WA22S9K', 1),
                                                                           ('Diesel', 'BMW', 'X5', 'DW39UR4', 2),
                                                                           ('Petrol', 'Audi', 'A4', 'DW8M7PS', 2),
                                                                           ('Diesel', 'Mercedes', 'GLC', 'DW92NT6', 2);



INSERT INTO trip (date, distance, fuel_consumption, trip_name, car_id) VALUES
                                                                           ('2025-01-01', 120, 10.2, 'Trip to the Mountains', 1),
                                                                           ('2025-01-02', 250, 21.0, 'City Travel', 1),
                                                                           ('2025-01-03', 300, 25.5, 'Beach Getaway', 1),
                                                                           ('2025-01-04', 500, 42.5, 'Long Drive', 1),
                                                                           ('2025-01-05', 150, 12.6, 'Weekend Trip', 1),
                                                                           ('2025-01-06', 650, 55.0, 'Holiday Travel', 2),
                                                                           ('2025-01-07', 220, 18.4, 'Mountain Adventure', 2),
                                                                           ('2025-01-08', 800, 72.0, 'Cross-Country Road Trip', 2),
                                                                           ('2025-01-09', 300, 25.5, 'Short Vacation', 2),
                                                                           ('2025-01-10', 120, 10.8, 'Local Exploration', 3),
                                                                           ('2025-01-11', 180, 15.3, 'Trip to the Lakes', 3),
                                                                           ('2025-01-12', 650, 55.0, 'Work Travel', 3),
                                                                           ('2025-01-13', 400, 34.0, 'Business Trip', 4),
                                                                           ('2025-01-14', 250, 21.0, 'Weekend Getaway', 4),
                                                                           ('2025-01-15', 500, 42.5, 'Summer Trip', 4),
                                                                           ('2025-01-16', 300, 25.5, 'Family Vacation', 4),
                                                                           ('2025-01-17', 700, 63.0, 'Exploring the Country', 4),
                                                                           ('2025-01-18', 150, 12.6, 'Quick Business Trip', 4),
                                                                           ('2025-01-19', 380, 32.3, 'Countryside Escape', 5),
                                                                           ('2025-01-20', 550, 46.7, 'Grand Tour', 5),
                                                                           ('2025-01-21', 220, 18.4, 'Friends Trip', 5),
                                                                           ('2025-01-22', 300, 25.5, 'Adventure Time', 5),
                                                                           ('2025-01-23', 450, 38.3, 'Hiking Trip', 6),
                                                                           ('2025-01-24', 180, 15.3, 'Quick Visit', 6),
                                                                           ('2025-01-25', 120, 10.8, 'Local Business', 6),
                                                                           ('2025-01-26', 600, 51.0, 'Road Trip with Friends', 6),
                                                                           ('2025-01-27', 400, 34.0, 'Client Meeting', 6),
                                                                           ('2025-02-07', 350, 29.7, 'Weekend Retreat', 1),
                                                                           ('2025-02-08', 450, 38.3, 'City-to-City', 1),
                                                                           ('2025-02-09', 600, 51.0, 'Cross-State Road Trip', 1),
                                                                           ('2025-02-10', 120, 10.8, 'Local Exploration', 1),
                                                                           ('2025-02-11', 200, 17.0, 'Trip to the Beach', 1),
                                                                           ('2025-02-12', 700, 63.0, 'Summer Vacation', 2),
                                                                           ('2025-02-13', 500, 42.5, 'Desert Drive', 2),
                                                                           ('2025-02-14', 400, 34.0, 'Night Adventure', 2),
                                                                           ('2025-02-15', 300, 25.5, 'Visit to the Mountain Range', 2),
                                                                           ('2025-02-16', 180, 15.3, 'Country Road', 2),
                                                                           ('2025-02-17', 650, 55.0, 'Family Reunion', 3),
                                                                           ('2025-02-18', 220, 18.4, 'Business Road Trip', 3),
                                                                           ('2025-02-19', 300, 25.5, 'Exploring Towns', 3),
                                                                           ('2025-02-20', 500, 42.5, 'Vacation Drive', 3),
                                                                           ('2025-02-21', 180, 15.3, 'Trip to the Winery', 4),
                                                                           ('2025-02-22', 600, 51.0, 'Cross-Country Exploration', 4),
                                                                           ('2025-02-23', 250, 21.0, 'City Sightseeing', 4),
                                                                           ('2025-02-24', 350, 29.7, 'Weekend Road Trip', 4),
                                                                           ('2025-02-25', 450, 38.3, 'Adventure Across State', 5),
                                                                           ('2025-02-26', 150, 12.6, 'Day Trip to the Coast', 5),
                                                                           ('2025-02-27', 500, 42.5, 'Mountain Expedition', 5),
                                                                           ('2025-02-28', 300, 25.5, 'Visit to the Farm', 5),
                                                                           ('2025-03-01', 650, 55.0, 'Hiking and Camping', 6),
                                                                           ('2025-03-02', 400, 34.0, 'Urban Road Trip', 6),
                                                                           ('2025-03-03', 120, 10.8, 'Short Drive', 6),
                                                                           ('2025-03-04', 180, 15.3, 'Visiting Family', 6),
                                                                           ('2025-03-05', 220, 18.4, 'Out of Town Business', 6),
                                                                           ('2025-03-17', 300, 25.5, 'Touring the Towns', 1),
                                                                           ('2025-03-18', 150, 12.6, 'Family Visit', 1),
                                                                           ('2025-03-19', 650, 55.0, 'Family Road Trip', 1),
                                                                           ('2025-03-20', 220, 18.4, 'Quick Business', 1),
                                                                           ('2025-03-21', 300, 25.5, 'City Exploration', 2),
                                                                           ('2025-03-22', 500, 42.5, 'Road Trip Adventure', 2),
                                                                           ('2025-04-01', 150, 12.6, 'Weekend Getaway', 3),
                                                                           ('2025-04-02', 220, 18.4, 'City Business Trip', 3),
                                                                           ('2025-04-03', 300, 25.5, 'Family Vacation', 3),
                                                                           ('2025-04-04', 400, 34.0, 'Long Road Trip', 4),
                                                                           ('2025-04-05', 500, 42.5, 'Desert Tour', 4),
                                                                           ('2025-04-06', 650, 55.0, 'Country Exploration', 5),
                                                                           ('2025-04-07', 120, 10.8, 'Local Travel', 5),
                                                                           ('2025-04-08', 220, 18.4, 'Nature Retreat', 5),
                                                                           ('2025-04-09', 300, 25.5, 'Weekend Getaway', 6),
                                                                           ('2025-04-10', 500, 42.5, 'Business Travel', 6);


INSERT INTO car_expense (car_cost, date, expense_name, car_id) VALUES
                                                                   (200.75, '2025-01-01', 'Tire Replacement', 1),
                                                                   (150.30, '2025-01-02', 'Technical Inspection', 1),
                                                                   (300.00, '2025-01-03', 'Air Conditioning Repair', 1),
                                                                   (50.00, '2025-01-04', 'Oil Change', 1),
                                                                   (105.50, '2025-01-05', 'Brake Replacement', 2),
                                                                   (450.20, '2025-01-06', 'Engine Repair', 2),
                                                                   (250.80, '2025-01-07', 'Battery Replacement', 2),
                                                                   (500.60, '2025-01-08', 'Suspension Repair', 3),
                                                                   (120.00, '2025-01-09', 'Technical Inspection', 3),
                                                                   (100.00, '2025-01-10', 'Brake Pad Replacement', 3),
                                                                   (200.40, '2025-01-11', 'Tire Replacement', 4),
                                                                   (300.00, '2025-01-12', 'Exhaust System Repair', 4),
                                                                   (180.25, '2025-01-13', 'Air Conditioning Repair', 4),
                                                                   (220.10, '2025-01-14', 'Battery Replacement', 5),
                                                                   (150.00, '2025-01-15', 'Technical Inspection', 5),
                                                                   (250.00, '2025-01-16', 'Tire Replacement', 5),
                                                                   (400.00, '2025-01-17', 'Engine Repair', 5),
                                                                   (300.50, '2025-01-18', 'Suspension Repair', 6),
                                                                   (90.00, '2025-01-19', 'Oil Change', 6),
                                                                   (500.30, '2025-01-20', 'Brake System Replacement', 6),
                                                                   (110.50, '2025-01-21', 'Brake Pad Replacement', 6),
                                                                   (250.00, '2025-02-01', 'Tire Replacement', 1),
                                                                   (180.20, '2025-02-02', 'Technical Inspection', 1),
                                                                   (300.00, '2025-02-03', 'Air Conditioning Repair', 1),
                                                                   (150.75, '2025-02-04', 'Oil Change', 2),
                                                                   (500.10, '2025-02-05', 'Suspension Repair', 2),
                                                                   (220.00, '2025-02-06', 'Brake System Replacement', 2),
                                                                   (350.00, '2025-02-07', 'Engine Repair', 3),
                                                                   (200.50, '2025-02-08', 'Battery Replacement', 3),
                                                                   (150.00, '2025-02-09', 'Brake Pad Replacement', 3),
                                                                   (400.00, '2025-02-10', 'Suspension Repair', 4),
                                                                   (300.25, '2025-02-11', 'Technical Inspection', 4),
                                                                   (230.75, '2025-02-12', 'Tire Replacement', 5),
                                                                   (120.30, '2025-02-13', 'Exhaust System Repair', 5),
                                                                   (100.50, '2025-02-14', 'Brake Pad Replacement', 5),
                                                                   (350.00, '2025-02-15', 'Oil Change', 6),
                                                                   (450.00, '2025-02-16', 'Air Conditioning Repair', 6),
                                                                   (220.20, '2025-02-17', 'Suspension Repair', 6),
                                                                   (300.00, '2025-02-18', 'Brake System Replacement', 6),
                                                                   (200.75, '2025-03-19', 'Engine Repair', 1),
                                                                   (500.00, '2025-03-20', 'Battery Replacement', 1),
                                                                   (150.00, '2025-03-21', 'Brake Pad Replacement', 2),
                                                                   (180.30, '2025-03-22', 'Suspension Repair', 2),
                                                                   (220.00, '2025-03-23', 'Oil Change', 2),
                                                                   (350.00, '2025-03-24', 'Air Conditioning Repair', 3),
                                                                   (400.75, '2025-03-25', 'Brake System Replacement', 3),
                                                                   (300.00, '2025-03-26', 'Technical Inspection', 4),
                                                                   (230.00, '2025-03-27', 'Tire Replacement', 5),
                                                                   (120.00, '2025-03-28', 'Suspension Repair', 5),
                                                                   (500.00, '2025-03-01', 'Engine Repair', 6),
                                                                   (350.50, '2025-03-02', 'Brake Pad Replacement', 6);


INSERT INTO fuel_expense (date, fuel_amount, fuel_cost, price_per_liter, car_id) VALUES
                                                                                     ('2025-01-01', 22.4, 148.80, 6.64, 1),
                                                                                     ('2025-02-01', 25.0, 170.00, 6.80, 1),
                                                                                     ('2025-03-01', 20.0, 140.00, 7.00, 1),
                                                                                     ('2025-01-02', 18.0, 126.00, 7.00, 2),
                                                                                     ('2025-02-02', 22.5, 157.50, 6.90, 2),
                                                                                     ('2025-03-02', 21.0, 147.00, 7.10, 2),
                                                                                     ('2025-01-03', 25.0, 175.00, 7.00, 3),
                                                                                     ('2025-02-03', 19.5, 136.50, 6.80, 3),
                                                                                     ('2025-03-03', 23.0, 161.00, 7.00, 3),
                                                                                     ('2025-01-04', 20.0, 140.00, 6.90, 4),
                                                                                     ('2025-02-04', 21.0, 147.00, 6.75, 4),
                                                                                     ('2025-03-04', 18.5, 129.50, 7.00, 4),
                                                                                     ('2025-01-05', 15.0, 105.00, 7.00, 5),
                                                                                     ('2025-02-05', 16.5, 115.50, 6.50, 5),
                                                                                     ('2025-03-05', 17.0, 119.00, 6.90, 5),
                                                                                     ('2025-01-06', 27.0, 189.00, 7.00, 6),
                                                                                     ('2025-02-06', 24.5, 171.50, 6.90, 6),
                                                                                     ('2025-03-06', 29.0, 203.00, 7.00, 6),
                                                                                     ('2025-01-07', 22.0, 154.00, 6.90, 1),
                                                                                     ('2025-02-07', 23.5, 164.50, 7.00, 1),
                                                                                     ('2025-03-07', 21.5, 150.50, 7.30, 1),
                                                                                     ('2025-01-08', 25.0, 175.00, 6.80, 1),
                                                                                     ('2025-02-08', 24.0, 168.00, 7.10, 2),
                                                                                     ('2025-03-08', 26.0, 182.00, 7.20, 2),
                                                                                     ('2025-01-09', 18.5, 129.50, 6.70, 2),
                                                                                     ('2025-02-09', 20.5, 143.50, 7.00, 2),
                                                                                     ('2025-03-09', 19.0, 133.00, 7.30, 3),
                                                                                     ('2025-01-10', 23.5, 164.50, 6.90, 3),
                                                                                     ('2025-02-10', 22.0, 154.00, 7.00, 3),
                                                                                     ('2025-03-10', 24.0, 168.00, 7.10, 3),
                                                                                     ('2025-01-11', 21.0, 147.00, 7.00, 4),
                                                                                     ('2025-02-11', 20.5, 143.50, 6.90, 4),
                                                                                     ('2025-03-11', 19.5, 136.50, 7.00, 4),
                                                                                     ('2025-01-12', 24.0, 168.00, 7.00, 4),
                                                                                     ('2025-02-12', 25.5, 178.50, 7.10, 4),
                                                                                     ('2025-03-12', 23.0, 161.00, 6.90, 5),
                                                                                     ('2025-01-13', 20.0, 140.00, 7.10, 5),
                                                                                     ('2025-02-13', 22.5, 157.50, 7.00, 5),
                                                                                     ('2025-03-13', 21.0, 147.00, 7.30, 5),
                                                                                     ('2025-01-14', 19.0, 133.00, 6.90, 6),
                                                                                     ('2025-02-14', 18.5, 129.50, 6.75, 6),
                                                                                     ('2025-03-14', 20.0, 140.00, 7.20, 6),
                                                                                     ('2025-01-15', 23.0, 161.00, 7.00, 6),
                                                                                     ('2025-02-15', 24.5, 171.50, 6.80, 1),
                                                                                     ('2025-03-15', 22.0, 154.00, 7.10, 1),
                                                                                     ('2025-01-16', 21.5, 150.50, 7.30, 1),
                                                                                     ('2025-02-16', 22.0, 154.00, 7.00, 1),
                                                                                     ('2025-03-16', 23.5, 164.50, 6.90, 2),
                                                                                     ('2025-01-17', 24.0, 168.00, 7.00, 2),
                                                                                     ('2025-02-17', 23.0, 161.00, 6.90, 2),
                                                                                     ('2025-03-17', 25.0, 175.00, 7.10, 2),
                                                                                     ('2025-01-18', 18.0, 126.00, 6.60, 3),
                                                                                     ('2025-02-18', 19.5, 136.50, 7.00, 3),
                                                                                     ('2025-03-18', 20.0, 140.00, 7.20, 3),
                                                                                     ('2025-01-19', 22.0, 154.00, 6.80, 3),
                                                                                     ('2025-02-19', 23.0, 161.00, 7.10, 4),
                                                                                     ('2025-03-19', 24.0, 168.00, 6.90, 4),
                                                                                     ('2025-01-20', 20.5, 143.50, 7.00, 4),
                                                                                     ('2025-02-20', 21.5, 150.50, 6.90, 4),
                                                                                     ('2025-03-20', 19.0, 133.00, 7.10, 5),
                                                                                     ('2025-01-20', 20.5, 143.50, 7.00, 5),
                                                                                     ('2025-02-20', 21.5, 150.50, 6.90, 5),
                                                                                     ('2025-01-21', 22.0, 154.00, 6.80, 5),
                                                                                     ('2025-02-21', 23.0, 161.00, 7.10, 6),
                                                                                     ('2025-01-22', 24.0, 168.00, 7.00, 6),
                                                                                     ('2025-02-22', 25.0, 175.00, 7.20, 6);


INSERT INTO trip_expense (trip_id, expense_name, trip_cost) VALUES
                                                                (1, 'Parking fee', 15.50),
                                                                (2, 'Toll fee', 5.30),
                                                                (3, 'Parking fine', 45.20),
                                                                (4, 'Toll fee', 10.00),
                                                                (5, 'Parking fee', 12.50),
                                                                (6, 'Toll fee', 6.75),
                                                                (7, 'Parking fine', 50.00),
                                                                (8, 'Toll fee', 8.00),
                                                                (9, 'Parking fee', 14.00),
                                                                (10, 'Parking fine', 60.00),
                                                                (11, 'Toll fee', 7.50),
                                                                (12, 'Parking fee', 13.00),
                                                                (13, 'Toll fee', 6.00),
                                                                (14, 'Parking fine', 40.00),
                                                                (15, 'Toll fee', 9.00),
                                                                (16, 'Parking fee', 17.00),
                                                                (17, 'Toll fee', 5.50),
                                                                (18, 'Parking fine', 30.00),
                                                                (19, 'Toll fee', 7.30),
                                                                (20, 'Parking fee', 18.00),
                                                                (21, 'Toll fee', 6.20),
                                                                (22, 'Parking fine', 55.00),
                                                                (23, 'Toll fee', 4.80),
                                                                (24, 'Parking fee', 16.50),
                                                                (25, 'Toll fee', 7.00),
                                                                (26, 'Parking fine', 45.00),
                                                                (27, 'Toll fee', 5.60),
                                                                (28, 'Parking fee', 12.00),
                                                                (29, 'Toll fee', 8.20),
                                                                (30, 'Parking fine', 50.00),
                                                                (31, 'Toll fee', 6.40),
                                                                (32, 'Parking fee', 14.20),
                                                                (33, 'Toll fee', 5.80),
                                                                (34, 'Parking fine', 60.00),
                                                                (35, 'Toll fee', 7.10),
                                                                (36, 'Parking fee', 13.80),
                                                                (37, 'Toll fee', 8.50),
                                                                (38, 'Parking fine', 70.00),
                                                                (39, 'Toll fee', 6.90),
                                                                (40, 'Parking fee', 15.00),
                                                                (41, 'Toll fee', 5.20),
                                                                (42, 'Parking fine', 65.00),
                                                                (43, 'Toll fee', 6.10),
                                                                (44, 'Parking fee', 14.80),
                                                                (45, 'Toll fee', 8.30),
                                                                (46, 'Parking fine', 40.00),
                                                                (47, 'Toll fee', 6.50),
                                                                (48, 'Parking fee', 17.00),
                                                                (49, 'Toll fee', 7.40),
                                                                (50, 'Parking fine', 55.00),
                                                                (51, 'Toll fee', 5.70),
                                                                (52, 'Parking fee', 12.90),
                                                                (53, 'Toll fee', 7.60),
                                                                (54, 'Parking fine', 48.00),
                                                                (55, 'Toll fee', 6.30),
                                                                (56, 'Parking fee', 14.40),
                                                                (57, 'Toll fee', 8.10),
                                                                (58, 'Parking fine', 52.00),
                                                                (59, 'Toll fee', 5.90),
                                                                (60, 'Parking fee', 16.10),
                                                                (61, 'Toll fee', 7.20),
                                                                (62, 'Parking fine', 50.00),
                                                                (63, 'Toll fee', 6.60),
                                                                (64, 'Parking fee', 15.40),
                                                                (65, 'Toll fee', 8.50),
                                                                (66, 'Parking fine', 60.00),
                                                                (67, 'Toll fee', 6.00),
                                                                (68, 'Parking fee', 14.10),
                                                                (69, 'Toll fee', 7.80),
                                                                (70, 'Parking fine', 45.00),
                                                                (1, 'Toll fee', 5.40),
                                                                (2, 'Parking fee', 16.50),
                                                                (3, 'Toll fee', 8.00),
                                                                (4, 'Parking fine', 62.00),
                                                                (5, 'Toll fee', 6.70),
                                                                (6, 'Parking fee', 13.50),
                                                                (7, 'Toll fee', 5.80),
                                                                (8, 'Parking fine', 38.00),
                                                                (9, 'Toll fee', 7.90),
                                                                (10, 'Parking fee', 14.30),
                                                                (11, 'Toll fee', 5.50),
                                                                (12, 'Parking fine', 53.00),
                                                                (12, 'Toll fee', 6.10),
                                                                (13, 'Parking fee', 15.20),
                                                                (14, 'Toll fee', 8.00),
                                                                (15, 'Parking fine', 65.00),
                                                                (16, 'Toll fee', 7.00),
                                                                (17, 'Parking fee', 13.00),
                                                                (18, 'Toll fee', 6.90),
                                                                (20, 'Parking fine', 58.00);

INSERT INTO delivery (id, status, driver_id, delivery_request_id, pickuplocation, droplocation, created_at, updated_at) VALUES
(1, TRUE, 1, 1, 'Bangalore', 'Mysore', NOW(), NOW()),
(2, FALSE, 2, 2, 'Hyderabad', 'Chennai', NOW(), NOW()),
(3, TRUE, 3, 3, 'Pune', 'Mumbai', NOW(), NOW()),
(4, FALSE, 4, 4, 'Delhi', 'Agra', NOW(), NOW()),
(5, TRUE, 5, 5, 'Kolkata', 'Ranchi', NOW(), NOW());

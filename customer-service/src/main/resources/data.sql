-- Customer table
INSERT INTO customer (id, name, contact_number, email, created_at) VALUES
(1, 'Alice Johnson', 9876543101, 'alice1@example.com', NOW()),
(2, 'Bob Smith', 9876543102, 'bob2@example.com', NOW()),
(3, 'Charlie Brown', 9876543103, 'charlie3@example.com', NOW()),
(4, 'David Lee', 9876543104, 'david4@example.com', NOW()),
(5, 'Emma Watson', 9876543105, 'emma5@example.com', NOW());

-- DeliveryRequest table
INSERT INTO delivery_request (id, customer_id, pickup_location, drop_location, request_date) VALUES
(1, 1, 'Bangalore', 'Mysore', NOW()),
(2, 2, 'Hyderabad', 'Chennai', NOW()),
(3, 3, 'Pune', 'Mumbai', NOW()),
(4, 4, 'Delhi', 'Agra', NOW()),
(5, 5, 'Kolkata', 'Ranchi', NOW());

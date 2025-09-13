INSERT INTO tracking (id, delivery_id, status, current_location, timestamp, remarks) VALUES
(1, 1, 'PICKED_UP', 'Bangalore', NOW(), 'Package picked by driver'),
(2, 2, 'IN_TRANSIT', 'Nellore', NOW(), 'Moving to Chennai'),
(3, 3, 'OUT_FOR_DELIVERY', 'Mumbai', NOW(), 'Near delivery point'),
(4, 4, 'DELAYED', 'Agra', NOW(), 'Traffic issue'),
(5, 5, 'DELIVERED', 'Ranchi', NOW(), 'Package delivered successfully');

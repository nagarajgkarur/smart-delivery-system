INSERT INTO notification (id, delivery_id, driver_id, customer_contact, message, sent_at, status, channel) VALUES
(1, 1, 1, '9876543101', 'Your package is picked up.', NOW(), 'SENT', 'SMS'),
(2, 2, 2, '9876543102', 'Your package is out for delivery.', NOW(), 'SENT', 'EMAIL'),
(3, 3, 3, '9876543103', 'Your package has been delivered.', NOW(), 'FAILED', 'SMS'),
(4, 4, 4, '9876543104', 'Delivery delayed due to traffic.', NOW(), 'SENT', 'PUSH'),
(5, 5, 5, '9876543105', 'Package rescheduled.', NOW(), 'SENT', 'EMAIL');

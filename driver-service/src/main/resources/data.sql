-- Driver table (assumed schema: id, name, licenseNumber, phoneNumber)
INSERT INTO driver (id, name, vehicle_number, contact_number,registered_at) VALUES
(1, 'Ravi Kumar', 'DL1234', '9876500001',CURRENT_DATE),
(2, 'Suresh Singh', 'DL5678', '9876500002',CURRENT_DATE),
(3, 'Anita Rao', 'DL9101', '9876500003',CURRENT_DATE),
(4, 'Kiran Das', 'DL1213', '9876500004',CURRENT_DATE),
(5, 'Meena Nair', 'DL1415', '9876500005',CURRENT_DATE) ON DUPLICATE KEY UPDATE id = id;

-- DriverDelivery table
INSERT INTO driver_delivery (id, driver_id, delivery_id, accepted_at) VALUES
(1, 1, 1, CURRENT_DATE),
(2, 2, 2, CURRENT_DATE),
(3, 3, 3, CURRENT_DATE),
(4, 4, 4, CURRENT_DATE),
(5, 5, 5, CURRENT_DATE);

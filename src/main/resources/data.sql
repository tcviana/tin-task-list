INSERT INTO VEHICLE (ID, VEICULO, MARCA, ANO, DESCRICAO, VENDIDO, CREATED, UPDATED)
VALUES(1, 'UNO', 'FIAT', 1990, 'COMPLETO', FALSE, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(2, 'ONIX', 'GM', 2020, 'LTZ', FALSE, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(3, 'UP', 'VW', 2018, 'TSI', FALSE, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(4, 'CIVIC', 'HONDA', 2016, 'AUTOMATIC', TRUE, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(5, 'JETTA', 'VW', 2012, 'TSI', FALSE, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(6, 'GOL', 'VW', 2014, 'TREND', TRUE, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
(7, 'COROLLA', 'TOYOTA', 2020, 'TSI', TRUE, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

alter sequence vehicle_seq restart with 11
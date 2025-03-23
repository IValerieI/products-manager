CREATE TABLE IF NOT EXISTS price_history (
    id                  UUID            PRIMARY KEY,
    start_date          TIMESTAMP       NOT NULL,
    end_date            TIMESTAMP,
    price_archived      NUMERIC(8, 2)   NOT NULL,
    product_id          UUID            REFERENCES product (id)  NOT NULL
);

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('a7a8031b-1f4e-4bb1-8a0e-eba47421870c', '2025-01-01T12:00:00', null, 50, '02d4e764-340c-4822-87bb-5d8be1a80d2e');

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('5906ed46-4286-41f9-af25-3dafbff12273', '2025-01-01T12:00:00', null, 60, 'c8e2b639-f610-4fab-8cb4-ec3c2bdc346d');

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('4b0c5cc5-eb1d-40fa-aff3-ea73fe50a43a', '2025-01-01T12:00:00', null, 70, 'df13b6c3-7114-49f1-85cc-c50b29c49d18');

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('6b3cdf7e-ee02-4328-8b79-eb181a27f5c5', '2025-01-01T12:00:00', null, 80, '816a2c94-6f7a-446b-92e5-1f69650f8b56');

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('459f9ccc-42eb-424d-9c2a-a4f2a5ee703a', '2025-01-01T12:00:00', null, 40, '9438fdb0-b89b-4e91-8f03-901b6923044b');

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('55a35f1f-d948-4cb3-ad26-808c6d5ec26f', '2025-01-01T12:00:00', null, 65, '7b53e763-03cf-4009-82cf-13c60ed93cf2');

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('5e2d38dc-90f9-4fc9-b27f-7601fd39f0df', '2025-01-01T12:00:00', null, 90, 'f2182cf4-5d38-4489-8b2f-f465917759e4');

INSERT INTO price_history (id, start_date, end_date, price_archived, product_id)
VALUES ('31b1886b-a676-4a9c-98a3-eae77d3b8382', '2025-01-01T12:00:00', null, 100, 'e2327a80-ddb6-402e-9251-50af8dd1ab5a');


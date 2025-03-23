BEGIN TRANSACTION;

    CREATE TABLE IF NOT EXISTS seller (
        id          UUID            PRIMARY KEY,
        name        VARCHAR(20)     NOT NULL UNIQUE,
        description VARCHAR(100)
    );

    CREATE TABLE IF NOT EXISTS customer (
        id          UUID            PRIMARY KEY,
        name        VARCHAR(20)     NOT NULL UNIQUE,
        description VARCHAR(100)
    );

    CREATE TABLE IF NOT EXISTS product (
        id              UUID            PRIMARY KEY,
        current_price   NUMERIC(8, 2)   NOT NULL,
        name            VARCHAR(20)     NOT NULL UNIQUE,
        description     VARCHAR(100)
    );

    CREATE TABLE IF NOT EXISTS deal (
        id            UUID            PRIMARY KEY,
        date          DATE            NOT NULL,
        seller_id     UUID            REFERENCES seller (id)  NOT NULL,
        customer_id   UUID            REFERENCES customer (id)  NOT NULL
    );

    CREATE TABLE IF NOT EXISTS supply (
        id              UUID            PRIMARY KEY,
        date            DATE            NOT NULL,
        price_paid      NUMERIC(8, 2)   NOT NULL,
        weight          NUMERIC(6, 2)   NOT NULL,
        seller_id       UUID            REFERENCES seller (id)  NOT NULL,
        customer_id     UUID            REFERENCES customer (id)  NOT NULL,
        deal_id         UUID            REFERENCES deal (id)  NOT NULL,
        product_id      UUID            REFERENCES product (id)  NOT NULL
    );

COMMIT;
create database wallet2;
\c wallet2;

CREATE TABLE IF NOT EXISTS "Currency" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) UNIQUE NOT NULL,
    code VARCHAR(3) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS "Account" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    pay DOUBLE PRECISION NOT NULL,
    last_update_date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_currency INT REFERENCES  "Currency"(id),
    type VARCHAR(20) CHECK (type IN ('Banque', 'Espèce', 'Mobile Money'))
);

CREATE TABLE IF NOT EXISTS "Transaction" (
    id SERIAL PRIMARY KEY,
    label VARCHAR(200) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type VARCHAR(10) CHECK (type IN ('debit', 'credit')),
    id_account INT REFERENCES "Account"(id)
);

CREATE TABLE IF NOT EXISTS "Account_transaction"(
    id SERIAL PRIMARY KEY,
    id_transaction INT REFERENCES "Transaction"(id),
    id_account INT REFERENCES "Account"(id)
);



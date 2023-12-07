create database wallet2;
\c wallet2;


CREATE TABLE IF NOT EXISTS Devise (
    devise_id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    code VARCHAR(3) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Transaction (
    id SERIAL PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    sold numeric(10, 2) NOT NULL,
    date_heure TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    type_transaction VARCHAR(10) CHECK (type_transaction IN ('debit', 'credit')) NOT NULL
);



CREATE TABLE IF NOT EXISTS Account (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sold DECIMAL(10, 2) NOT NULL,
    date_last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    devise_id INT REFERENCES Devise(devise_id),
     type_compte VARCHAR(20) CHECK (type_compte IN ('Banque', 'Espèce', 'Mobile Money')) NOT NULL
);

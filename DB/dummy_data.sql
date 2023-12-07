INSERT INTO "Currency" (name, code) VALUES
('US Dollar', 'USD'),
('Euro', 'EUR'),
('British Pound', 'GBP'),
('Japanese Yen', 'JPY'),
('Canadian Dollar', 'CAD');


INSERT INTO "Account" (name, pay, id_currency, type) VALUES
('Savings Account', 5000.00, 1, 'Banque'),
('Cash Wallet', 200.00, 2, 'Espèce'),
('Mobile Wallet', 100.00, 3, 'Mobile Money'),
('Checking Account', 8000.00, 1, 'Banque'),
('Emergency Fund', 3000.00, 2, 'Banque');


INSERT INTO "Transaction" (label, amount, type, id_account) VALUES
('Grocery Shopping', 50.00, 'debit', 1),
('Salary Deposit', 3000.00, 'credit', 4),
('Dinner with Friends', 30.00, 'debit', 2),
('Electricity Bill', 80.00, 'debit', 5),
('Bonus Received', 1000.00, 'credit', 1);


INSERT INTO "Account_transaction" (id_transaction, id_account) VALUES
(1, 1),
(2, 4),
(3, 2),
(4, 5),
(5, 1);

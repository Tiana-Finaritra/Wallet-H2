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


INSERT INTO "Transaction_category" (name, items_list) VALUES
('Nourriture et Boissons', 'Alimentation, Household, Bar, café, Restaurant, fast-food'),
('Achats et boutiques en ligne', 'Animaux de compagnie, Bijoux, accessoires, Cadeaux, Electronique, accessoires, '),
('Dining', 'Food, Entertainment'),
('Utilities', 'Bills'),
('Bonus', 'Income');


INSERT INTO "Transaction" (label, amount, type, id_account, id_category) VALUES
('Grocery Shopping', 50.00, 'debit', 1, 1),
('Salary Deposit', 3000.00, 'credit', 4, 2),
('Dinner with Friends', 30.00, 'debit', 2, 3),
('Electricity Bill', 80.00, 'debit', 5, 4),
('Bonus Received', 1000.00, 'credit', 1, 5);


INSERT INTO "Account_transaction" (id_transaction, id_account) VALUES
(1, 1),
(2, 4),
(3, 2),
(4, 5),
(5, 1);

    CREATE OR REPLACE FUNCTION get_category_sum_for_account(
        account_id INT,
        start_date TIMESTAMP,
        end_date TIMESTAMP
    )
    RETURNS TABLE (category_name VARCHAR(255), total_amount NUMERIC) AS
    $$
    BEGIN
        RETURN QUERY
        SELECT categories.category_name, COALESCE(SUM(CASE WHEN transactions.type = 'Crédit' THEN transactions.amount ELSE -transactions.amount END), 0)
        FROM categories
        LEFT JOIN transactions ON categories.category_name = transactions.label
            AND transactions.account_id = account_id_param
            AND transactions.transaction_date BETWEEN start_date_param AND end_date_param
        GROUP BY categories.category_name;
    END;
    $$
    LANGUAGE plpgsql;

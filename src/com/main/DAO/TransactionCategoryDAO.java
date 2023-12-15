package com.main.DAO;

import com.main.generic.GenericDAO;
import com.main.model.TransactionCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionCategoryDAO implements GenericDAO<TransactionCategory> {

    private Connection connection;

    public TransactionCategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public TransactionCategoryDAO() {

    }

    @Override
    public List<TransactionCategory> findAll() {
        List<TransactionCategory> categories = new ArrayList<>();

        String sql = "SELECT * FROM \"Transaction_category\"";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                TransactionCategory category = new TransactionCategory();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setItemsList(resultSet.getString("items_list"));

                categories.add(category);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des catégories de transaction", e);
        }

        return categories;
    }

    @Override
    public List<TransactionCategory> saveAll(List<TransactionCategory> toSave) {
        List<TransactionCategory> savedCategories = new ArrayList<>();

        String sql = "INSERT INTO \"Transaction_category\" (name, items_list) VALUES (?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET name = EXCLUDED.name, items_list = EXCLUDED.items_list RETURNING id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            for (TransactionCategory category : toSave) {
                preparedStatement.setString(1, category.getName());
                preparedStatement.setString(2, category.getItemsList());

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int generatedId = resultSet.getInt("id");
                    category.setId(generatedId);
                    savedCategories.add(category);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement des catégories de transaction", e);
        }

        return savedCategories;
    }

    @Override
    public TransactionCategory save(TransactionCategory toSave) {
        String sql = "INSERT INTO \"Transaction_category\" (name, items_list) VALUES (?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET name = EXCLUDED.name, items_list = EXCLUDED.items_list RETURNING id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, toSave.getName());
            preparedStatement.setString(2, toSave.getItemsList());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int generatedId = resultSet.getInt("id");
                toSave.setId(generatedId);
                return toSave;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'enregistrement de la catégorie de transaction", e);
        }

        return null;
    }

    @Override
    public TransactionCategory delete(TransactionCategory toDelete) {
        String sql = "DELETE FROM \"Transaction_category\" WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, toDelete.getId());

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Catégorie de transaction avec l'ID " + toDelete.getId() + " supprimée avec succès.");
                return toDelete;
            } else {
                System.out.println("Catégorie de transaction avec l'ID " + toDelete.getId() + " non trouvée.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression de la catégorie de transaction", e);
        }

        return null;
    }
}

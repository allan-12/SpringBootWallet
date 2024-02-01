package com.example.springwallet.repository;

import com.example.springwallet.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
    private Connection connection;

    @Override
    public void insert(Transaction transaction) {
        String sql = "INSERT INTO Transaction (id, label, amount, dateTime, account_id, type) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, transaction.getId());
            statement.setString(2, transaction.getLabel());
            statement.setDouble(3, transaction.getAmount());
            statement.setObject(4, transaction.getDateTime());
            statement.setString(5, transaction.getAccount_id());
            statement.setString(6, transaction.getType().name());

            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("Insertion réussie : " + insert);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void update(String id, Transaction transaction) {
        String sql = "UPDATE Transaction SET label = ?, amount = ?, dateTime = ?, account_id = ?, type = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, transaction.getLabel());
            statement.setDouble(2, transaction.getAmount());
            statement.setObject(3, transaction.getDateTime());
            statement.setString(4, transaction.getAccount_id());
            statement.setString(5, transaction.getType().name());
            statement.setString(6, id);

            int update = statement.executeUpdate();
            if (update > 0) {
                System.out.println("Mise à jour réussie : " + update);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Transaction WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            int delete = statement.executeUpdate();
            if (delete > 0) {
                System.out.println("Suppression réussie : " + delete);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Transaction findById(String id) {
        Transaction transaction = null;
        String sql = "SELECT * FROM Transaction WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                transaction = new Transaction(
                        resultSet.getString("id"),
                        resultSet.getString("label"),
                        resultSet.getDouble("amount"),
                        resultSet.getObject("dateTime", LocalDateTime.class),
                        resultSet.getString("account_id"),
                        Transaction.TransactionType.valueOf(resultSet.getString("type"))
                );
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transaction";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Transaction transaction = new Transaction(
                        resultSet.getString("id"),
                        resultSet.getString("label"),
                        resultSet.getDouble("amount"),
                        resultSet.getObject("dateTime", LocalDateTime.class),
                        resultSet.getString("account_id"),
                        Transaction.TransactionType.valueOf(resultSet.getString("type"))
                );
                transactions.add(transaction);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        return transactions;
    }

}

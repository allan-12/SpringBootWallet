package com.example.springwallet.repository;

import com.example.springwallet.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
@AllArgsConstructor
@Repository
public class AccountRepositoryImpl implements AccountRepository{
    private Connection connection;

    @Override
    public void insert(Account account) {
        String sql = "INSERT INTO Account (id, name, balance, currency, type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, account.getId());
            statement.setString(2, account.getName());
            statement.setDouble(3, account.getBalance());
            statement.setString(4, account.getCurrency().getCurrencyCode());
            statement.setString(5, account.getType().name());

            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("Insertion réussie : " + insert);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void update(String id, Account account) {
        String sql = "UPDATE Account SET name = ?, balance = ?, currency = ?, type = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, account.getName());
            statement.setDouble(2, account.getBalance());
            statement.setString(3, account.getCurrency().getCurrencyCode());
            statement.setString(4, account.getType().name());
            statement.setString(5, id);

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
        String sql = "DELETE FROM Account WHERE id = ?";
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
    public Account findById(String id) {
        Account account = null;
        String sql = "SELECT * FROM Account WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                account = new Account(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("balance"),
                        null, // Assuming transactions are not loaded here
                        Currency.getInstance(resultSet.getString("currency")),
                        Account.AccountType.valueOf(resultSet.getString("type"))
                );
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Account account = new Account(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("balance"),
                        null, // Assuming transactions are not loaded here
                        Currency.getInstance(resultSet.getString("currency")),
                        Account.AccountType.valueOf(resultSet.getString("type"))
                );
                accounts.add(account);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        return accounts;
    }
}

package com.example.springwallet.repository;

import com.example.springwallet.model.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Repository
public class CurrencyRepositoryImp implements CurrencyRepository{
    private final Connection connection;

    @Override
    public void insert(Currency currency) {
        String sql = "INSERT INTO Currency (id, name, code) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currency.getId());
            statement.setString(2, currency.getName().name());
            statement.setString(3, currency.getCode().name());

            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("Insertion réussie : " + insert);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    @Override
    public void update(String id, Currency currency) {
        String sql = "UPDATE Currency SET name = ?, code = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currency.getName().name());
            statement.setString(2, currency.getCode().name());
            statement.setString(3, id);

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
        String sql = "DELETE FROM Currency WHERE id = ?";
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
    public Currency findById(String id) {
        Currency currency = null;
        String sql = "SELECT * FROM Currency WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                currency = new Currency(
                        resultSet.getString("id"),
                        Currency.Name.valueOf(resultSet.getString("name")),
                        Currency.Code.valueOf(resultSet.getString("code"))
                );
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        return currency;
    }

    @Override
    public List<Currency> findAll() {
        List<Currency> currencies = new ArrayList<>();
        String sql = "SELECT * FROM Currency";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Currency currency = new Currency(
                        resultSet.getString("id"),
                        Currency.Name.valueOf(resultSet.getString("name")),
                        Currency.Code.valueOf(resultSet.getString("code"))
                );
                currencies.add(currency);
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
        return currencies;
    }
}

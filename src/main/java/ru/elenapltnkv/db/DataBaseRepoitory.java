package ru.elenapltnkv.db;

import ru.elenapltnkv.dao.NUserRes2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseRepoitory {
    private static String DB_URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=reqres";
    private static String username = "postgres";
    private static String password = "1380";
    String insertUsersInfo = "insert into users(email, first_name, last_name, avatar) values (?, ?, ?, ?)";
    String insertCreateUsersInfo = "insert into new_users(name, job, id, createdAt) values (?, ?, ?, ?)";
    String selectNewUsersInfo = "select * from new_users where id='?'";

    static {
        try {
            Class.forName("org.postgresql.Driver");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(User.Data user) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(insertUsersInfo);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirst_name());
            preparedStatement.setString(3, user.getLast_name());
            preparedStatement.setString(4, user.getAvatar());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveNewUser(NUserRes2 ures) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(insertCreateUsersInfo);
            preparedStatement.setString(1, ures.getName());
            preparedStatement.setString(2, ures.getJob());
            preparedStatement.setString(3, ures.getId());
            preparedStatement.setString(4, ures.getCreatedAt());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String selectUser(String id) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(selectNewUsersInfo);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }
}

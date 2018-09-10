/**
 * UserAdminDAO
 */

package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAdminDAO {
    protected static Connection getConnection() throws SQLException {
        String host = "localhost";
        String port = "3306";
        String database = "useradmin";
        String username = "admin";
        String password = "admin@123";
        String dbUrl = "jdbc:mysql://" + host + ":" + port + "/" +database;
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public boolean isVaidUser(User user) throws Exception{
        Connection connection;
        boolean result = false;
        try {
                connection = getConnection();
                //Statement stmt = connection.createStatement();
                String query = "SELECT * FROM USERINFO WHERE USERNAME = ? AND PASSWORD = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());                
                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    result = true;
                } 
                connection.close();
            } catch (Exception e) {
                throw e;
            }
            return result;
    }

}
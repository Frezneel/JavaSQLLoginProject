package db;

import constants.CommonConstants;

import javax.xml.transform.Result;
import java.sql.*;

// JDBC - Java Database Connectivity
// Class ini sebagai penghubung/gerbang untuk mengakses database MySQL kita
public class MyJDBC {
    public static boolean register(String username, String password){

        try {
            // First check if the username already exists in the database
            if(!checkUser(username)){
                // Menghubungkan ke database
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                        CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

                // membuat insert query
                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO "+ CommonConstants.DB_USERS_TABLE_NAME + "(username, password)"+
                                "VALUES (?, ?)"
                );

                // insert parameters in the insert query
                insertUser.setString(1, username);
                insertUser.setString(2, password);

                insertUser.executeUpdate();
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean checkUser(String username){
        try {
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME +
                            " WHERE USERNAME = ?"
            );
            checkUserExists.setString(1,username);
            ResultSet resultSet = checkUserExists.executeQuery();

            // check to see if the result set is empty
            // if it is empty it means that there no data row that contains the username
            // (i.e user does not exitst)
            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    // validate login credentials by checking to see if username/password pair exits in the database
    public static boolean validateLogin(String username, String password){
        try {
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

            PreparedStatement validateUser = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME +
                            " WHERE USERNAME = ? AND PASSWORD = ?"
            );
            validateUser.setString(1,username);
            validateUser.setString(2,password);

            ResultSet resultSet = validateUser.executeQuery();

            if (!resultSet.isBeforeFirst()){
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test;DB_CLOSE_ON_EXIT=false;FILE_LOCK=NO";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "12345";
    private static Database dbIsntance;
    private static Connection conn;


    private Database() {
        // private constructor //
    }

    public static Database getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new Database();
        }
        return dbIsntance;
    }

    public Connection getConnection() {

        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                String host = DB_URL;
                String username = USER;
                String password = PASS;
                conn = DriverManager.getConnection(host, username, password);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return conn;
    }
}

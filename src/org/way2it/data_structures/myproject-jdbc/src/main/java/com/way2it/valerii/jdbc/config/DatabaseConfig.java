package com.way2it.valerii.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
  private static final String POSTGRE_DRIVER = "org.postgresql.Driver";

  private static final String URL = "jdbc:postgresql://localhost/db_library";

  private static final String USER = "postgres";

  private static final String PASSWORD = "1111";

  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(POSTGRE_DRIVER);

    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}

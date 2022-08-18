package com.way2it.valerii.jdbc.dao;

import com.way2it.valerii.jdbc.config.DatabaseConfig;
import com.way2it.valerii.jdbc.entity.AutorEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class LibraryDaoImpl implements LibraryDao {

  private static Connection connection;
  static {
    try {
      connection = DatabaseConfig.getConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Override
  public List<AutorEntity> getAllAutors() {
    List<AutorEntity> autorEntities = new ArrayList<>();
    try (Statement statement = connection.createStatement();){
      ResultSet resultSet = statement.executeQuery("SELECT * FROM tb_autor order by id");
      while (resultSet.next()) {
        String ownerName = resultSet.getString("owner_name");
        String ownerSurname = resultSet.getString("owner_surname");
        Date ownerDate = resultSet.getDate("owner_dt");
        int id = resultSet.getInt("id");
        String ownerEmail = resultSet.getString("owner_email");
        autorEntities.add(new AutorEntity(id,ownerDate,ownerEmail,ownerName,ownerSurname));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return autorEntities;
  }

  @Override
  public AutorEntity getAutorById(Integer id) {
    try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_autor Where id = ?")){
      statement.setInt(1,id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        String ownerName = resultSet.getString("owner_name");
        String ownerSurname = resultSet.getString("owner_surname");
        Date ownerDate = resultSet.getDate("owner_dt");
        String ownerEmail = resultSet.getString("owner_email");
        return new AutorEntity(id,ownerDate,ownerEmail,ownerName,ownerSurname);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override
  public void addAutors(Date autorDate, String autorEmail, String autorName, String autorSurname) {
    try (PreparedStatement statement = connection.prepareStatement("INSERT INTO tb_autor(owner_dt, owner_email, owner_name, owner_surname) values(?,?,?,?)")){
      statement.setDate(1,  autorDate);
      statement.setString(2,autorEmail);
      statement.setString(3,autorName);
      statement.setString(4,autorSurname);
      statement.executeUpdate();
      statement.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  @Override
  public void updateAutor(int id, Date autorDate, String autorEmail, String autorName,String autorSurname) {
    try (PreparedStatement statement = connection.prepareStatement("UPDATE tb_autor set owner_dt=?, owner_email=?, owner_name=?, owner_surname=? WHERE ID=?")){
      statement.setDate(1, autorDate);
      statement.setString(2,autorEmail);
      statement.setString(3,autorName);
      statement.setString(4,autorSurname);
      statement.setInt(5, id);
      System.out.println(statement.executeUpdate());
      statement.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }
}

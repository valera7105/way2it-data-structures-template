package com.way2it.valerii.jdbc.dao;

import com.way2it.valerii.jdbc.entity.AutorEntity;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface LibraryDao {

  List<AutorEntity> getAllAutors() throws SQLException;

  public AutorEntity getAutorById(Integer id) throws SQLException;

  void addAutors(Date autorDate, String autorEmail, String autorName,String autorSurname)
      throws SQLException;

  void updateAutor(int id,  Date autorDate, String autorEmail, String autorName,String autorSurname);
}

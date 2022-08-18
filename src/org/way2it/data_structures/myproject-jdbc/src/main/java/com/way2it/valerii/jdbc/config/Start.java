package com.way2it.valerii.jdbc.config;

import com.way2it.valerii.jdbc.dao.LibraryDao;
import com.way2it.valerii.jdbc.dao.LibraryDaoImpl;
import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;

public class Start {

  public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
    LibraryDao libraryDao = new LibraryDaoImpl();
    libraryDao.getAllAutors().forEach(System.out::println);
    System.out.println(libraryDao.getAutorById(17));
    Date date = Date.valueOf("1971-05-11");

    libraryDao.addAutors(date,"valera@gmail.com","Valerii","Leliukh");
    date = Date.valueOf("1971-04-01");
    libraryDao.updateAutor(17,date,"td.natalia@gmail.com","Nataliya","Soroka");

    System.out.println(libraryDao.getAutorById(17));
  }
}
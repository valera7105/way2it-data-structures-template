package com.way2it.valerii.jdbc.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class AutorEntity {
  private int id;
  private Date autorDate;
  private String autorEmail;
  private String autorName;
  private String autorSurname;

}

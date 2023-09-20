package com.security.springSecurity.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private String userName;
  private String password;
  private String email;
  private String role;


}

package com.example.backend;

@Entity
public class Admin {
   @Id(strategy = GeneratedVlue.IDENTITY)
   private Long id;
   private Long username;
   private String name;
   private String password
}
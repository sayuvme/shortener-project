package com.example.shortener.feature.user.dto;
import jakarta.validation.constraints.*;
public class RegisterForm { @NotBlank @Size(min=3,max=50) private String username; @NotBlank @Email private String email; @NotBlank @Size(min=6,max=100) private String password; public String getUsername(){return username;} public void setUsername(String v){username=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} }

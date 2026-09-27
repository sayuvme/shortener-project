package com.example.shortener.feature.user.entity;
import jakarta.persistence.*;
@Entity @Table(name="user_profiles")
public class UserProfile { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private String avatarUrl; private String timezone="UTC"; @Column(unique=true) private String apiToken; @OneToOne(fetch=FetchType.LAZY) @JoinColumn(name="user_id",nullable=false,unique=true) private User user; public UserProfile(){} public UserProfile(String token){apiToken=token;} public void setUser(User u){user=u;} public String getApiToken(){return apiToken;} }

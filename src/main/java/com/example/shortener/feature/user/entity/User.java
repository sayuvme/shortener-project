package com.example.shortener.feature.user.entity;

import com.example.shortener.feature.link.entity.ShortLink;
import jakarta.persistence.*; import java.util.*;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String username="";
 @Column(nullable=false) private String password="";
 @Column(nullable=false,unique=true) private String email="";
 @Column(nullable=false) private boolean enabled=true;
 @OneToOne(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true) private UserProfile profile;
 @OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true) private List<ShortLink> links=new ArrayList<>();
 public User(){} public User(String username,String email,String password){this.username=username;this.email=email;this.password=password;}
 public Long getId(){return id;} public String getUsername(){return username;} public void setUsername(String v){username=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public boolean isEnabled(){return enabled;} public void setProfile(UserProfile p){profile=p;} public UserProfile getProfile(){return profile;} public List<ShortLink> getLinks(){return links;}
}

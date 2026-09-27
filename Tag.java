package com.example.shortener.feature.tag.entity;
import com.example.shortener.feature.link.entity.ShortLink; import jakarta.persistence.*; import java.util.*;
@Entity @Table(name="tags") public class Tag { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true) private String name; @ManyToMany(mappedBy="tags") private Set<ShortLink> links=new HashSet<>(); public Tag(){} public Tag(String name){this.name=name;} public String getName(){return name;} public Long getId(){return id;} }

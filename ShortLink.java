package com.example.shortener.feature.link.entity;
import com.example.shortener.feature.tag.entity.Tag; import com.example.shortener.feature.user.entity.User; import jakarta.persistence.*; import java.time.*; import java.util.*;
@Entity @Table(name="short_links") public class ShortLink {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true,length=16) private String code; @Column(nullable=false,length=2048) private String originalUrl; @Column(nullable=false) private LocalDateTime createdAt=LocalDateTime.now(); @Column(nullable=false) private boolean active=true;
 @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name="user_id",nullable=false) private User user; @OneToMany(mappedBy="shortLink",cascade=CascadeType.ALL,orphanRemoval=true) private List<Click> clicks=new ArrayList<>();
 @ManyToMany(fetch=FetchType.LAZY) @JoinTable(name="link_tags",joinColumns=@JoinColumn(name="link_id"),inverseJoinColumns=@JoinColumn(name="tag_id")) private Set<Tag> tags=new HashSet<>();
 public ShortLink(){} public ShortLink(String code,String url,User user){this.code=code;this.originalUrl=url;this.user=user;} public Long getId(){return id;} public String getCode(){return code;} public String getOriginalUrl(){return originalUrl;} public void setOriginalUrl(String v){originalUrl=v;} public User getUser(){return user;} public List<Click> getClicks(){return clicks;} public Set<Tag> getTags(){return tags;} public void setTags(Set<Tag> t){tags=t;} public boolean isActive(){return active;}
}

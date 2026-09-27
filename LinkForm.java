package com.example.shortener.feature.link.dto;
import jakarta.validation.constraints.*;
public class LinkForm { @NotBlank @Pattern(regexp="^https?://.+",message="URL must start with http:// or https://") private String originalUrl; private String tagsRaw=""; public LinkForm(){} public LinkForm(String url,String tags){originalUrl=url;tagsRaw=tags;} public String getOriginalUrl(){return originalUrl;} public void setOriginalUrl(String v){originalUrl=v;} public String getTagsRaw(){return tagsRaw;} public void setTagsRaw(String v){tagsRaw=v;} }

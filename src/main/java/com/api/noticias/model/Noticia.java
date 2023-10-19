package com.api.noticias.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="noticia")
@Getter
@Setter
public class Noticia {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
    private Long id;
    @Column(name="title",nullable=false,length = 1000)
    private String title;
    @Column(name="url",nullable=false,length = 500)
    private String url;
    @Column(name="image_url",nullable=false,length = 500)
    private String image_url;
    @Column(name="news_site",nullable=false,length = 500)
    private String news_site;
    @Column(name="summary",nullable=false,length = 1000)
    private String summary;
    @Column(name="published_at",nullable=false)
    private Date published_at;
    @Column(name="updated_at",nullable=false)
    private Date updated_at;
    @Column(name="featured",nullable=false)
    private boolean featured;

}

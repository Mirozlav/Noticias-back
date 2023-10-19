package com.api.noticias.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NoticiaContract {
    private Long id;

    private String title;
    
    private String url;

    private String image_url;

    private String news_site;

    private String summary;

    private Date published_at;

    private Date updated_at;

    private boolean featured;
}

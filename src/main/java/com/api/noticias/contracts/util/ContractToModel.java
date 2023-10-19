package com.api.noticias.contracts.util;

import com.api.noticias.contracts.NoticiaContract;
import com.api.noticias.model.Noticia;

public class ContractToModel {

    public static Noticia toModel(NoticiaContract contract) {
        Noticia model = new Noticia();
        model.setTitle(contract.getTitle());
        model.setUrl(contract.getUrl());
        model.setImage_url(contract.getImage_url());
        model.setNews_site(contract.getNews_site());
        model.setSummary(contract.getSummary());
        model.setPublished_at(contract.getPublished_at());
        model.setUpdated_at(contract.getUpdated_at());
        model.setFeatured(contract.isFeatured());
        return model;
    }
}

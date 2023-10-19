package com.api.noticias.contracts.util;

import com.api.noticias.contracts.NoticiaContract;
import com.api.noticias.model.Noticia;

public class ModelToContract {

    public static NoticiaContract toContract(Noticia model) {
        NoticiaContract contrato = new NoticiaContract();
        contrato.setId(model.getId());
        contrato.setTitle(model.getTitle());
        contrato.setUrl(model.getUrl());
        contrato.setImage_url(model.getImage_url());
        contrato.setNews_site(model.getNews_site());
        contrato.setSummary(model.getSummary());
        contrato.setPublished_at(model.getPublished_at());
        contrato.setUpdated_at(model.getUpdated_at());
        contrato.setFeatured(model.isFeatured());

        return contrato;
    }
}

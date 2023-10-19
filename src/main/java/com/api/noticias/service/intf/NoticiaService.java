package com.api.noticias.service.intf;

import com.api.noticias.model.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NoticiaService {
    Noticia Save(Noticia noticia);

    Optional<Noticia> findById(Long id);

    void deleteById(Long id);
    Page<Noticia> getAll(Pageable pageable);
    Page<Noticia> buscarNoticia(String pTitulo,Pageable pageable);
}

package com.api.noticias.service.intf;

import com.api.noticias.model.Noticia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface NoticiaService {
    Noticia Save(Noticia noticia) throws Exception;

    Optional<Noticia> findById(Long id);

    ResponseEntity<?> deleteById(Long id);
    Page<Noticia> getAll(Pageable pageable) throws Exception;
    Page<Noticia> buscarNoticia(String pTitulo,Pageable pageable) throws Exception;
}

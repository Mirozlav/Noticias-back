package com.api.noticias.service.impl;


import com.api.noticias.repository.NoticiaRepository;
import com.api.noticias.service.intf.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import com.api.noticias.model.Noticia;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServiceImpl implements NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    @Override
    public Noticia Save(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @Override
    public Optional<Noticia> findById(Long id) {
        return noticiaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        noticiaRepository.deleteById(id);
    }

    @Override
    public Page<Noticia> getAll(Pageable pageable) {
        return noticiaRepository.findAll(pageable);
    }

    @Override
    public Page<Noticia> buscarNoticia(String pTitulo,Pageable pageable) {
        List<Noticia> listaNoticia= noticiaRepository.buscarNoticia("%"+pTitulo+"%");

        return new PageImpl<>(listaNoticia, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                pageable.getSort()),listaNoticia.size()) ;
    }
}

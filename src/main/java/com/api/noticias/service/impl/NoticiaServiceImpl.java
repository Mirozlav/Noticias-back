package com.api.noticias.service.impl;


import com.api.noticias.contracts.NoticiaContract;
import com.api.noticias.contracts.util.ContractToModel;
import com.api.noticias.contracts.util.ModelToContract;
import com.api.noticias.repository.NoticiaRepository;
import com.api.noticias.service.intf.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.noticias.model.Noticia;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServiceImpl implements NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    @Override
    public Noticia Save(Noticia pNoticia) throws Exception {
        Noticia noticia;
        try {
               noticia= noticiaRepository.save(pNoticia);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return noticia;
    }

    @Override
    public Optional<Noticia> findById(Long id) {
        return noticiaRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        try {
            noticiaRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<Noticia> getAll(Pageable pageable) throws Exception {
        Page<Noticia> listaNoticia;
        try {
            listaNoticia = noticiaRepository.findAll(pageable);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaNoticia;
    }

    @Override
    public Page<Noticia> buscarNoticia(String pTitulo,Pageable pageable) throws Exception {
        List<Noticia> listaNoticia;
        try {
           listaNoticia = noticiaRepository.buscarNoticia("%" + pTitulo + "%");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return new PageImpl<>(listaNoticia, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                pageable.getSort()),listaNoticia.size()) ;
    }
}

package com.api.noticias.api;

import com.api.noticias.contracts.NoticiaContract;
import com.api.noticias.contracts.util.ContractToModel;
import com.api.noticias.contracts.util.ModelToContract;
import com.api.noticias.model.Noticia;
import com.api.noticias.service.intf.NoticiaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/noticias")
public class NoticiaController {

    @Autowired
    NoticiaService noticiaService;

    @Operation(summary ="listar todas las noticias",description = "listar todas las noticias paginadas")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ) throws Exception{
        Page<Noticia> noticias = noticiaService.getAll(PageRequest.of(page,size, Sort.by(order)));
        if(!asc)
            noticias =noticiaService.getAll(PageRequest.of(page,size, Sort.by(order).descending()));
        return new ResponseEntity<>(noticias, HttpStatus.OK);
    }

    @Operation(summary ="buscar noticias destacadas por titulo",description = "buscar noticias destacadas por titulo")
    @GetMapping(value = "/{pTitulo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNoticias(@PathVariable("pTitulo") String pTitulo,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         @RequestParam(defaultValue = "title") String order,
                                         @RequestParam(defaultValue = "true") boolean asc) throws Exception{
        Page<Noticia> noticias= noticiaService.buscarNoticia(pTitulo,PageRequest.of(page,size, Sort.by(order)));
            if(!asc)
                noticias = noticiaService.buscarNoticia(pTitulo,PageRequest.of(page,size, Sort.by(order).descending()));
        return new ResponseEntity<>(noticias, HttpStatus.OK);
    }

    @Operation(summary = "agregar noticias",description = "agregar noticias")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody NoticiaContract contrato) throws Exception{
            Noticia noticia = noticiaService.Save(ContractToModel.toModel(contrato));
            return new ResponseEntity<>(ModelToContract.toContract(noticia), HttpStatus.CREATED);

    }

    @Operation(summary = "modificar valores de noticias",description = "modificar valores de noticias")
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody NoticiaContract contrato) throws Exception {
        Optional<Noticia> noticia = noticiaService.findById(id);

        if (noticia.isPresent()) {
            Noticia _noticia = noticia.get();//dato recuperado

            _noticia.setTitle(contrato.getTitle());
            _noticia.setUrl(contrato.getUrl());
            _noticia.setImage_url(contrato.getImage_url());
            _noticia.setNews_site(contrato.getNews_site());
            _noticia.setSummary(contrato.getSummary());
            _noticia.setPublished_at(contrato.getPublished_at());
            _noticia.setUpdated_at(contrato.getUpdated_at());
            _noticia.setFeatured(contrato.isFeatured());
            Noticia modificado = noticiaService.Save(_noticia);

            return new ResponseEntity<>(ModelToContract.toContract(modificado), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "eliminar noticias",description = "eliminar noticias")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") long id) {
            noticiaService.deleteById(id);
    }

}

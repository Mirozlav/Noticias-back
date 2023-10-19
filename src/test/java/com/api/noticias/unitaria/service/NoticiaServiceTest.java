package com.api.noticias.unitaria.service;

import com.api.noticias.contracts.NoticiaContract;
import com.api.noticias.contracts.util.ContractToModel;
import com.api.noticias.model.Noticia;
import com.api.noticias.repository.NoticiaRepository;
import com.api.noticias.service.intf.NoticiaService;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@ActiveProfiles("dev")
//@SpringBootTest(classes = {UnitTestConfig.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class NoticiaServiceTest {

    @InjectMocks
    private NoticiaService noticiaService;

    @MockBean
    private NoticiaRepository noticiaRepository;

    @Before("")
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    @Order(1)
    void testFindById(){
        assertThatThrownBy(
                () ->noticiaService.findById(Long.parseLong("1")));
    }
    @Test
    @Order(1)
    void testSave(){
        NoticiaContract noticiaContract= new NoticiaContract();
        noticiaContract.setId(Long.parseLong("1"));
        noticiaContract.setSummary("summary");
        noticiaContract.setTitle("titulo");
        noticiaContract.setUrl("url");
        noticiaContract.setNews_site("site");
        noticiaContract.setImage_url("image_url");
        noticiaContract.setPublished_at(new Date());
        noticiaContract.setUpdated_at(new Date());
        noticiaContract.setFeatured(true);
        assertThatThrownBy(
                () ->noticiaService.Save(ContractToModel.toModel(noticiaContract)));

    }

    @Test
    @Order(1)
    void testDeleteById(){
        assertThatThrownBy(
                () ->noticiaService.deleteById(Long.parseLong("1")));
    }

    @Test
    @Order(1)
    void testGetAll(){
        assertThatThrownBy(
                () ->noticiaService.getAll(PageRequest.of(0,10, Sort.by("title"))));
    }



}

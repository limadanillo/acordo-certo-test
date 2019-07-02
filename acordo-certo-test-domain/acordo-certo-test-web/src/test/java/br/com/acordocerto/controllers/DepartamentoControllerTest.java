package br.com.acordocerto.controllers;

import br.com.acordo.controller.DepartamentoController;
import br.com.acordo.domain.Departamento;
import br.com.acordo.service.DepartamentoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DepartamentoController.class)
public class DepartamentoControllerTest {

    private Departamento departamento;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartamentoService departamentoService;

    @Before
    public void setUp() {
        departamento = Departamento.builder()
                .id(1)
                .nome("teste nome")
                .descricao("teste descricao")
                .build();
    }

}

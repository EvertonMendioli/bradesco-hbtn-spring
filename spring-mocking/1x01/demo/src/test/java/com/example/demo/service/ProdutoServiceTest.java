package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {


    @Mock
    private ProdutoRepository produtoRepository;


    @InjectMocks
    private ProdutoService produtoService;


    @Test
    void deveRetornarProdutoQuandoIdExistir() {
      Produto prd = new Produto();
      prd.setId(1);
      prd.setNome("teste");
      prd.setPreco(4.2);

      when(produtoRepository.findById(Mockito.anyLong()));

      //assertEquals(prd, teste);

    }


    @Test
    void deveLancarExcecaoQuandoProdutoNaoExistir() {
      Produto prd = new Produto();
      prd.setId(2);
      prd.setNome("teste");
      prd.setPreco(4.2);

      //Produto teste = produtoService.buscarPorId(1);
            when(produtoRepository.findById(Mockito.anyLong())).thenThrow(new RuntimeException("Produto não encontrado"));


      //assertEquals(prd, teste);
    }
}

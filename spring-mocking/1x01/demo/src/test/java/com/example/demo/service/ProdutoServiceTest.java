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


@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {


    @Mock
    private ProdutoRepository produtoRepository;


    @InjectMocks
    private ProdutoService produtoService;


    @Test
    void deveRetornarProdutoQuandoIdExistir() {
      // implemente
    }


    @Test
    void deveLancarExcecaoQuandoProdutoNaoExistir() {
      // implemente
    }
}

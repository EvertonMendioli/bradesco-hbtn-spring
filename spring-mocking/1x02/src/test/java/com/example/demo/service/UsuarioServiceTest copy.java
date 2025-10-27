package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

  @Mock
  private UsuarioRepository usuarioRepository;

  @InjectMocks
  private UsuarioService usuarioService;

  @Test
  void deveRetornarProdutoQuandoIdExistir() {
    Produto prd = new Produto();
    prd.setId(1L);
    prd.setNome("teste");
    prd.setPreco(4.2);

    when(produtoRepository.findById(1L)).thenReturn(Optional.of(prd));

    Produto resultado = produtoService.buscarPorId(1L);

    assertNotNull(resultado);
    assertEquals(prd.getId(), resultado.getId());
    assertEquals(prd.getNome(), resultado.getNome());
    assertEquals(prd.getPreco(), resultado.getPreco());

  }

  @Test
  void deveLancarExcecaoQuandoProdutoNaoExistir() {

    when(produtoRepository.findById(1L)).thenThrow(new RuntimeException("Produto não encontrado"));

    RuntimeException exception = assertThrows(RuntimeException.class, () -> {
      produtoService.buscarPorId(1L);
    });

    assertEquals("Produto não encontrado", exception.getMessage());

  }
}

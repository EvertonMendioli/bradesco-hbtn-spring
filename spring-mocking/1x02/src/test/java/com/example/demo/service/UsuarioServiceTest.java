package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

  @Mock
  private UsuarioRepository usuarioRepository;

  @InjectMocks
  private UsuarioService usuarioService;

  @BeforeEach
  void setUp() {
      MockitoAnnotations.openMocks(this); // Initialize mocks
  }

  @Test
  void deveRetornarUsuarioQuandoIdExistir() {

      Usuario usuario = new Usuario(1L, "Teste", "teste@teste.com");
      Mockito.lenient().when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

      Usuario resultado = usuarioService.buscarUsuarioPorId(Mockito.anyLong());

      assertEquals(1L, resultado.getId());
      assertEquals("Teste", resultado.getNome());
      assertEquals("teste@teste.com", resultado.getEmail());
  }


  @Test
  void deveLancarExcecaoQuandoUsuarioNaoExistir() {

      Mockito.lenient().when(usuarioRepository.findById(1L)).thenThrow(new RuntimeException("Usuário não encontrado"));

      RuntimeException exception = assertThrows(RuntimeException.class, () -> {
          usuarioService.buscarUsuarioPorId(1L);
      });
  
      assertEquals("Usuário não encontrado", exception.getMessage());
  }

  @Test
  void deveSalvarUsuarioComSucesso(){
    Usuario usr = new Usuario(1L, "TESTE", "teste@teste.com.br");
    when(usuarioRepository.save(usr)).thenReturn(usr);
    Usuario savedUsuario = usuarioRepository.save(usr);

    assertEquals(1L, savedUsuario.getId());
    assertEquals("TESTE", savedUsuario.getNome());
    assertEquals("teste@teste.com.br", savedUsuario.getEmail());




  }
}

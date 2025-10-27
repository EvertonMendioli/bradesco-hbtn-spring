package main.java.com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Usuario;
import com.example.demo.repository.ProdutoRepository;

import main.java.com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

        private final UsuarioRepository usuarioRepository;

            


    public Produto buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }



}

package com.example.demo.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioRepository {

    public Optional<Usuario> findById(Long id) ;
    public Usuario save(Usuario Usuario);



    
}

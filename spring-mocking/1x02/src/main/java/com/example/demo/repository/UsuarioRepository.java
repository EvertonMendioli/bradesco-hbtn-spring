package main.java.com.example.demo.repository;


@Repository
public interface UsuarioRepository {

    public Optional<Usuario> findById(Long id);
    public Usuario save(Usuario Usuario);



    
}

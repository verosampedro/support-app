package dev.verosampedro.SupportAppProject.repositories;

import dev.verosampedro.SupportAppProject.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsuario(String usuario);

}

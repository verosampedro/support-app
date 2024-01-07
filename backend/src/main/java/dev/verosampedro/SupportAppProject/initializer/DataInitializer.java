package dev.verosampedro.SupportAppProject.initializer;

import dev.verosampedro.SupportAppProject.models.Solicitud;
import dev.verosampedro.SupportAppProject.models.Usuario;
import dev.verosampedro.SupportAppProject.repositories.SolicitudRepository;
import dev.verosampedro.SupportAppProject.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final SolicitudRepository solicitudRepository;

    public DataInitializer(UsuarioRepository usuarioRepository, SolicitudRepository solicitudRepository) {
        this.usuarioRepository = usuarioRepository;
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public void run(String... args) {

        Usuario usuario1 = new Usuario();
        usuario1.setUsuario("usuario1");
        usuario1.setContraseña("contrasena1");

        Solicitud solicitud1 = new Solicitud();
        solicitud1.setName("Nombre");
        solicitud1.setDate("Fecha");
        solicitud1.setTopic("Tema de la solicitud");
        solicitud1.setDescription("Descripción de la solicitud");
        solicitud1.setUsuario(usuario1);

        usuario1.getSolicitudes().add(solicitud1);

        usuarioRepository.save(usuario1);
        solicitudRepository.save(solicitud1);
        

    }
}

package dev.verosampedro.SupportAppProject.repositories;

import dev.verosampedro.SupportAppProject.models.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
   
}

package dev.verosampedro.SupportAppProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.verosampedro.SupportAppProject.models.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}

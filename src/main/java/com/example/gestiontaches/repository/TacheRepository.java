package com.example.gestiontaches.repository;

import com.example.gestiontaches.model.Tache;
import com.example.gestiontaches.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByStatut(Statut statut);

    long countByStatut(Statut statut);
}

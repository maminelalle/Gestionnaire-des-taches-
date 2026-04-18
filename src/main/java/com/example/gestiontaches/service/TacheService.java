package com.example.gestiontaches.service;

import com.example.gestiontaches.model.Tache;
import com.example.gestiontaches.model.Statut;
import com.example.gestiontaches.repository.TacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TacheService {
    private final TacheRepository repo;

    public List<Tache> findAll() {
        return repo.findAll();
    }

    public long countAll() {
        return repo.count();
    }

    public long countByStatut(Statut statut) {
        return repo.countByStatut(statut);
    }

    public Tache save(Tache t) {
        if (t.getPriorite() != null) {
            switch (t.getPriorite().toUpperCase()) {
                case "BASSE" -> t.setDateLimite(LocalDate.now().plusDays(7));
                case "HAUTE" -> t.setDateLimite(LocalDate.now().plusDays(1));
                case "MOYENNE" -> t.setDateLimite(LocalDate.now().plusDays(3));
                default -> t.setDateLimite(LocalDate.now().plusDays(7));
            }
        }
        return repo.save(t);
    }

    public Optional<Tache> findById(Long id) {
        return repo.findById(id);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Tache> filterByStatut(Statut statut) {
        return repo.findByStatut(statut);
    }
}

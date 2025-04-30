package com.example.gestiontaches.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    private LocalDate dateLimite;

    private String priorite; // HAUTE, MOYENNE, BASSE
}

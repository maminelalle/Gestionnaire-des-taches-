package com.example.gestiontaches;

import com.example.gestiontaches.model.Statut;
import com.example.gestiontaches.model.Tache;
import com.example.gestiontaches.service.TacheService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestiontachesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiontachesApplication.class, args);
	}

	@Bean
	CommandLineRunner seedDemoData(TacheService tacheService) {
		return args -> {
			if (tacheService.countAll() > 0) {
				return;
			}

			Tache tache1 = new Tache();
			tache1.setTitre("Préparer la présentation du projet");
			tache1.setDescription("Assembler les captures d’écran, vérifier les textes du README et finaliser le support de démo.");
			tache1.setPriorite("HAUTE");
			tache1.setStatut(Statut.EN_COURS);
			tacheService.save(tache1);

			Tache tache2 = new Tache();
			tache2.setTitre("Relire les fonctionnalités principales");
			tache2.setDescription("Vérifier les écrans de connexion, de liste et de création avant publication.");
			tache2.setPriorite("MOYENNE");
			tache2.setStatut(Statut.EN_ATTENTE);
			tacheService.save(tache2);

			Tache tache3 = new Tache();
			tache3.setTitre("Nettoyer la page d’accueil");
			tache3.setDescription("S’assurer que les compteurs et le visuel de hero restent lisibles sur mobile.");
			tache3.setPriorite("BASSE");
			tache3.setStatut(Statut.TERMINE);
			tacheService.save(tache3);

			Tache tache4 = new Tache();
			tache4.setTitre("Préparer la capture de la table");
			tache4.setDescription("Remplir la liste avec des badges colorés et des actions visibles pour le README.");
			tache4.setPriorite("MOYENNE");
			tache4.setStatut(Statut.EN_COURS);
			tacheService.save(tache4);
		};
	}

}

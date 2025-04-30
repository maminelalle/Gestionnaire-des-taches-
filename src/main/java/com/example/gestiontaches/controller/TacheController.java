package com.example.gestiontaches.controller;

import com.example.gestiontaches.model.Tache;
import com.example.gestiontaches.service.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TacheController {

    private final TacheService service;

    // On mappe la racine ET /accueil sur la même méthode
    @GetMapping({"/", "/accueil"})
    public String accueil() {
        return "accueil";  // renvoie à templates/accueil.html
    }

    @GetMapping("/taches")
    public String liste(Model model) {
        model.addAttribute("taches", service.findAll());
        return "taches"; // renvoie à templates/taches.html
    }

    @GetMapping("/ajouter")
    public String ajouterForm(Model model) {
        model.addAttribute("tache", new Tache());
        return "ajouter"; // renvoie à templates/ajouter.html
    }

    @PostMapping("/ajouter")
    public String save(@ModelAttribute Tache tache) {
        service.save(tache);
        return "redirect:/taches"; // Redirige vers /taches après avoir ajouté
    }

    @GetMapping("/modifier/{id}")
    public String modifierForm(@PathVariable Long id, Model model) {
        Tache tache = service.findById(id).orElseThrow(() -> new IllegalArgumentException("Tâche introuvable id=" + id));
        model.addAttribute("tache", tache);
        return "modifier"; // renvoie à templates/modifier.html
    }

    @PostMapping("/modifier")
    public String modifier(@ModelAttribute Tache tache) {
        service.save(tache);
        return "redirect:/taches"; // Redirige vers /taches après modification
    }

    @GetMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/taches"; // Redirige vers /taches après suppression
    }
}

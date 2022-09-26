package com.example.persogestionsalaries.entreprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/entreprise")
public class EntrepriseController {

    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping
    public List<Entreprise> getEntreprises() {
        return entrepriseService.getEntreprises();
    }

    @PostMapping
    public void addEntreprise(@RequestBody Entreprise entreprise) {
        entrepriseService.addNewEntreprise(entreprise);
    }
}

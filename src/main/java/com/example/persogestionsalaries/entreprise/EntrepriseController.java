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

    @DeleteMapping(path = "{entrepriseId}")
    public void deleteEntreprise(@PathVariable("entrepriseId") Long entrepriseId){
        entrepriseService.deleteEntreprise(entrepriseId);

    }

    @PutMapping(path = "{entrepriseId}")
    public void updateEntreprise (
            @PathVariable("entrepriseId") Long entrepriseId,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) LocalDate dateFondation) {

        entrepriseService.updateEntreprise(entrepriseId, nom, dateFondation);
    }

}

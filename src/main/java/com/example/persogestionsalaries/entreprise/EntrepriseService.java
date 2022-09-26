package com.example.persogestionsalaries.entreprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    public List<Entreprise> getEntreprises() {
        return entrepriseRepository.findAll();
    }

    public void addNewEntreprise(Entreprise entreprise) {
        System.out.println(entreprise);
    }
}

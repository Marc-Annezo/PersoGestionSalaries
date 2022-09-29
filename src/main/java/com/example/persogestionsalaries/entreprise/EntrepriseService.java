package com.example.persogestionsalaries.entreprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        Optional<Entreprise> entrepriseBySiret = entrepriseRepository.findEntrepriseBySiret(entreprise.getSiret());

        if(entrepriseBySiret.isPresent()){
            throw new IllegalStateException("l'entreprise existe déjà");
        }

        entrepriseRepository.save(entreprise);
    }
}

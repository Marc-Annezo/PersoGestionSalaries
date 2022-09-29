package com.example.persogestionsalaries.entreprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void deleteEntreprise(Long entrepriseId) {
        boolean exists = entrepriseRepository.existsById(entrepriseId);

        if(!exists) {
            throw new IllegalStateException("L'entreprise n'existe pas");
        }

        entrepriseRepository.deleteById(entrepriseId);
    }

    @Transactional
    public void updateEntreprise(Long entrepriseId, String nom, LocalDate dateFondation) {

        Entreprise entrepriseAModifier = entrepriseRepository.findById(entrepriseId)
                .orElseThrow(() -> new IllegalStateException("impossible de modifier puisque l'entreprise n'existe pas"));


        // On vérifie que le nom existe, est plus long que 0 caractères et qu'il n'est pas équivalent à la donnée modifiée
        if(!nom.isBlank()
                && nom.length()>0
                && !nom.equals(entrepriseAModifier.getNom())) {
            entrepriseAModifier.setNom(nom);
        }

        // On vérifie que la date de fondation est différente de celle déjà insérée, et qu'elle est antérieure à aujourd'hui).
        if(!dateFondation.isEqual(entrepriseAModifier.getDateFondation())
            && dateFondation.isBefore(LocalDate.now())) {
            entrepriseAModifier.setDateFondation(dateFondation);
        }
        entrepriseRepository.save(entrepriseAModifier);



    }
}

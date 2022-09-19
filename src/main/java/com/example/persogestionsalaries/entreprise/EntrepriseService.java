package com.example.persogestionsalaries.entreprise;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntrepriseService {

    public List<Entreprise> getEntreprise() {
        return List.of(
                new Entreprise(
                        123456789L,
                        "EntrepriseTest",
                        102,
                        LocalDate.of(2000, 01, 01)
                )
        );
    }
}

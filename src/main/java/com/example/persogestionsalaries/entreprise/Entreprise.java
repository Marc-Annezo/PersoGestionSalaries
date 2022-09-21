package com.example.persogestionsalaries.entreprise;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table
public class Entreprise {
    @Id
    @SequenceGenerator(
            name = "sequence_entreprise",
            sequenceName = "sequence_entreprise",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_entreprise"
    )
    private Long id;
    private Long immatriculationRCS;
    private String nom;
    private Integer effectifs;
    private LocalDate dateFondation;

    public Entreprise(Long id, Long immatriculationRCS, String nom, Integer effectifs, LocalDate dateFondation) {
        this.id = id;
        this.immatriculationRCS = immatriculationRCS;
        this.nom = nom;
        this.effectifs = effectifs;
        this.dateFondation = dateFondation;
    }

    public Entreprise() {
    }

    public Entreprise(Long immatriculationRCS, String nom, Integer effectifs, LocalDate dateFondation) {
        this.immatriculationRCS = immatriculationRCS;
        this.nom = nom;
        this.effectifs = effectifs;
        this.dateFondation = dateFondation;
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "id=" + id +
                ", immatriculationRCS=" + immatriculationRCS +
                ", nom='" + nom + '\'' +
                ", effectifs=" + effectifs +
                ", dateFondation=" + dateFondation +
                '}';
    }
}



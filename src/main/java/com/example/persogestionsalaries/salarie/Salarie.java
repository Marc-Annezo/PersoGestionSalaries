package com.example.persogestionsalaries.salarie;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter

@Entity
@Table
public class Salarie {

    @SequenceGenerator(
            name = "sequence_salarie",
            sequenceName = "sequence_salarie",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_salarie"
    )
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private LocalDate dateEmbauche;
    @Nullable
    private LocalDate dateFinContrat;

    public Salarie(Long id, String nom, String prenom, LocalDate dateEmbauche, LocalDate dateFinContrat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.dateFinContrat = dateFinContrat;
    }

    public Salarie(String nom, String prenom, LocalDate dateEmbauche, LocalDate dateFinContrat) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateEmbauche = dateEmbauche;
        this.dateFinContrat = dateFinContrat;
    }

    public Salarie() {
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", dateFinContrat=" + dateFinContrat +
                '}';
    }
}

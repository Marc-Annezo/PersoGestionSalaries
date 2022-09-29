package com.example.persogestionsalaries.entreprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

    // SELECT * FROM entreprise WHERE siret = ?
    @Query("SELECT s FROM Entreprise s WHERE s.siret=?1")
    Optional<Entreprise> findEntrepriseBySiret(Long siret);

    @Query("SELECT n FROM Entreprise n WHERE n.nom=?1")
    Optional<Entreprise> findEntrepriseByNom(String nom);
}

package com.example.persogestionsalaries.entreprise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EntrepriseConfig {

    @Bean
    CommandLineRunner commandLineRunner(EntrepriseRepository repository) {
        return args -> {
            Entreprise sasMoi = new Entreprise(
                12345678912345L,
                    "SASMoi",
                    13,
                    LocalDate.of(2000, Month.JANUARY, 1)
            );

            Entreprise sarlPlomberie = new Entreprise(
                    23456789123456L,
                    "SARL Plomberie",
                    19,
                    LocalDate.of(1991, Month.FEBRUARY, 11)
            );

            repository.saveAll(
                    List.of(sasMoi, sarlPlomberie)
            );
        };
    }
}

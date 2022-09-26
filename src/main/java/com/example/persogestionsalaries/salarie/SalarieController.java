package com.example.persogestionsalaries.salarie;

import com.example.persogestionsalaries.entreprise.Entreprise;
import com.example.persogestionsalaries.entreprise.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/salarie")
public class SalarieController {
        private final SalarieService salarieService;

        @Autowired
        public SalarieController(SalarieService salarieService) {
            this.salarieService = salarieService;
        }

}

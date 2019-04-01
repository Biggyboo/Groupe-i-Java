package com.mspr.API.POJO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface PersonneRepo extends CrudRepository<Personne, Long> {
    List<Personne> findPersonneByIdentifiant(String identifiant);
}

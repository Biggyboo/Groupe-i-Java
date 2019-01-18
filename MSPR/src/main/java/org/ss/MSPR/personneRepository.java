package org.ss.MSPR;

import org.ss.MSPR.personne;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface personneRepository extends CrudRepository<personne, Long> {
    List<personne> findByNom(String nom);
}

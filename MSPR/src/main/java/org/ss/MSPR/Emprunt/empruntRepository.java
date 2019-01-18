package org.ss.MSPR.Emprunt;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.ss.MSPR.Materiel.materiel;
import org.ss.MSPR.Personne.personne;

public interface empruntRepository extends CrudRepository<emprunt, Long> {
    List<emprunt> findByPersonne(personne personne);
    List<emprunt> findByMateriel(materiel materiel);
    
}

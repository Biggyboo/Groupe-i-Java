package org.ss.MSPR.Emprunt;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface empruntRepository extends CrudRepository<emprunt, Long> {
    //List<emprunt> findByLibelle(String libelle);
    
}

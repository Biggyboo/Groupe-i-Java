package org.ss.MSPR.Materiel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface materielRepository extends CrudRepository<materiel, Long> {
    List<materiel> findByLibelle(String libelle);
}

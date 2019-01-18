package org.ss.MSPR.Role;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface roleRepository extends CrudRepository<role, Long> {
    List<role> findByLibelle(String libelle);
}

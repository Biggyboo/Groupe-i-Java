package com.mspr.API.POJO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface MaterielRepo extends CrudRepository<Materiel, Long> {

}
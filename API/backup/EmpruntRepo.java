package com.mspr.API.POJO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Date;

@CrossOrigin(origins = "http://localhost:4200")
public interface EmpruntRepo extends CrudRepository<Emprunt, Long> {
    long countAllByRenduFalse();

    long countAllByDateFinIsBefore(Date dateFin);
}
package com.mspr.API.POJO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Embeddable;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Embeddable
public interface EmpruntRepo extends CrudRepository<Emprunt, String> {
    List<Emprunt> getEmpruntsByIdPersonne(long id);
}

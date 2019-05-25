package com.mspr.API;

import com.mspr.API.POJO.Materiel;
import com.mspr.API.POJO.MaterielRepo;
import com.mspr.API.configuration.RepoConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materialEmprunt")
@SessionAttributes("materialEmprunt")
public class GetMaterialEmprunt {

    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Materiel> run() {
        MaterielRepo materialRepository = (MaterielRepo) RepoConfig.contextProvider().getApplicationContext().getBean("materielRepo");
        List<Materiel> myList= materialRepository.getMaterielsByEmprunte(false);
        myList.forEach(materiel -> {
            materiel.setLeType(null);
            materiel.setLesEmprunts(null);
        });
        return myList;
    }
}

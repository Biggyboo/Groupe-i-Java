package com.mspr.API.POJO;

import com.mspr.API.configuration.RepoConfig;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empruntUser")
@SessionAttributes("empruntUser")
public class GetEmpruntByUser {

    @RequestMapping(method= RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Emprunt> run(@RequestBody Map<String,String> json) {
        EmpruntRepo empruntRepo=(EmpruntRepo) RepoConfig.contextProvider().getApplicationContext().getBean("empruntRepo");
        List<Emprunt> emprunts=empruntRepo.getEmpruntsByIdPersonne(Long.parseLong(json.get("id")));
        List<Emprunt> vreturn=new ArrayList<>(0);
        emprunts.forEach(emprunt -> {
            Emprunt myEmprunt=new Emprunt();
            myEmprunt.setIdMateriel(emprunt.getIdMateriel());
            myEmprunt.setIdPersonne(emprunt.getIdPersonne());
            myEmprunt.setDateemprunt(emprunt.getDateemprunt());
            myEmprunt.setUuid(emprunt.getUuid());
            vreturn.add(myEmprunt);
        });
        return vreturn;
    }
}

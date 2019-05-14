package com.mspr.API;

import com.mspr.API.POJO.Personne;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authentication")
@SessionAttributes("authentication")
public class Authentication {
    private int status = 0;
    private boolean switchSatus = false;
    public static Personne personne;

    private void changeStatus(int value) {
        if (!switchSatus) {
            status = value;
            switchSatus = true;
        }
    }

    @RequestMapping(method= RequestMethod.POST, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String run(@RequestBody String identifiant) {
        String response = "";
        switchSatus = false;
        try {
            checkIdentifiant(identifiant);
        } catch (Exception e) {
            e.printStackTrace();
            changeStatus(1);
        }
        switch (status) {
            case 0: response = "Problème majeur";
                break;
            case 1:  response = "Connexion OK";
                break;
            case 2:  response = "Identifiant incorrect";
                break;
            case 3:  response = "Erreur connexion";
                    break;
        }
        return response;
    }

    private void checkIdentifiant(String identifiant) {
        Personne personne = new Personne()  ;
        try{
            if(!(personne.findPersonneByIdentifiant(identifiant)==null)){
                changeStatus(1);
            }else{
                changeStatus(2);
            }
        }catch (Exception e){
            e.printStackTrace();
            changeStatus(3);
        }
    }
}

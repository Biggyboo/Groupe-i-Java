package com.mspr.API;

import com.mspr.API.POJO.Personne;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/authentication")
@SessionAttributes("authentication")
public class Authentication {
    public static Personne personne;

    @RequestMapping(method= RequestMethod.GET, produces = {"application/json"}, value = "/logout")
    @ResponseStatus(HttpStatus.OK)
    public static void logout() {
        personne = null;
    }
}

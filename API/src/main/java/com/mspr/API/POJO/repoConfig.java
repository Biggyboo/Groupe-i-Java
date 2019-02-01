package com.mspr.API.POJO;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class repoConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Personne.class);
<<<<<<< HEAD
        config.exposeIdsFor(Emprunt.class);
=======
>>>>>>> parent of ce36576... modif
    }
}
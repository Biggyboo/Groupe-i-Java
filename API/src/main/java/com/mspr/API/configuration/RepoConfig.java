package com.mspr.API.configuration;

import com.mspr.API.ApplicationContextProvider;
import com.mspr.API.POJO.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepoConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Personne.class);
        config.exposeIdsFor(Role.class);
        config.exposeIdsFor(Materiel.class);
        config.exposeIdsFor(Typemateriel.class);
        config.exposeIdsFor(Emprunt.class);
    }

    @Bean
    public static ApplicationContextProvider contextProvider() {
        return new ApplicationContextProvider();
    }
}
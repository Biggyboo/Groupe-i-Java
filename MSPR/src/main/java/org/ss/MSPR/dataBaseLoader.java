package org.ss.MSPR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
abstract class DatabaseLoader implements CommandLineRunner {

    private personneRepository personneRepository;

    @Autowired
    public DatabaseLoader(personneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.personneRepository.save(new personne("Cloarec", "Yann"));
        //personneRepository.findAll().forEach(System.out::println);
    }
}

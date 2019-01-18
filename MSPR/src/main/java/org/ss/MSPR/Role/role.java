package org.ss.MSPR.Role;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.ss.MSPR.Personne.personne;

@Entity
public class role {

    private @Id @GeneratedValue Long id;
    private String libelle;
    @OneToMany(mappedBy="role")
    private Collection<personne> personne;

    public role() {}

    public role(String libelle, personne personne) {
        this.libelle = libelle;
        this.personne.add(personne);
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
}

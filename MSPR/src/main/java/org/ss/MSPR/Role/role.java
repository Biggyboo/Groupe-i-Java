package org.ss.MSPR.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class role {

    private @Id @GeneratedValue Long id;
    private String libelle;

    public role() {}

    public role(String libelle) {
        this.libelle = libelle;
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

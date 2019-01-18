package org.ss.MSPR.Materiel;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.ss.MSPR.Emprunt.emprunt;

@Entity
public class materiel {

    private @Id @GeneratedValue Long id;
    private String libelle;
    private String description;
    private Long stock;
    @OneToMany
    private Collection<emprunt> emprunt;

    public materiel() {}

    public materiel(String libelle, String description, Long stock, emprunt emprunt) {
        this.libelle = libelle;
        this.description = description;
        this.stock = stock;
        this.emprunt.add(emprunt);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the stock
     */
    public Long getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Long stock) {
        this.stock = stock;
    }


}

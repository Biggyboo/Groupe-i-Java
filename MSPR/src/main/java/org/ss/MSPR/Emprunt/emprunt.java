package org.ss.MSPR.Emprunt;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.ss.MSPR.Materiel.materiel;
import org.ss.MSPR.Personne.personne;

@Entity
public class emprunt {

    private @Id @GeneratedValue Long id;
    private Date dateDeb;
    private Date dateFin;
    private Long quantite;
    @ManyToOne
    private personne personne;
    @ManyToOne
    private materiel materiel;

    public emprunt() {}

    public emprunt(Date dateDeb, Date dateFin, Long quantite, personne personne, materiel materiel){
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.quantite = quantite;
        this.personne = personne;
        this.materiel = materiel;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the dateDeb
     */
    public Date getDateDeb() {
        return dateDeb;
    }

    /**
     * @param dateDeb the dateDeb to set
     */
    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the quantite
     */
    public Long getQuantite() {
        return quantite;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

    /**
     * @return the personne
     */
    public personne getPersonne() {
        return personne;
    }

    /**
     * @param personne the personne to set
     */
    public void setPersonne(personne personne) {
        this.personne = personne;
    }

    /**
     * @return the materiel
     */
    public materiel getMateriel() {
        return materiel;
    }

    /**
     * @param materiel the materiel to set
     */
    public void setMateriel(materiel materiel) {
        this.materiel = materiel;
    }


}

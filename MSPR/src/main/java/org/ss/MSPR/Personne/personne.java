package org.ss.MSPR.Personne;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.ss.MSPR.Emprunt.emprunt;
import org.ss.MSPR.Role.role;

@Entity
public class personne {

    private @Id @GeneratedValue Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String visage;
    private String finContrat;
    @ManyToOne
    private role role;
    @OneToMany(mappedBy="personne")
    private Collection<emprunt> emprunt;

    public personne() {}

    public personne(String nom, String prenom, emprunt emprunt, role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.emprunt.add(emprunt);
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the visage
     */
    public String getVisage() {
        return visage;
    }

    /**
     * @param visage the visage to set
     */
    public void setVisage(String visage) {
        this.visage = visage;
    }

    /**
     * @return the finContrat
     */
    public String getFinContrat() {
        return finContrat;
    }

    /**
     * @param finContrat the finContrat to set
     */
    public void setFinContrat(String finContrat) {
        this.finContrat = finContrat;
    }

    /**
     * @return the role
     */
    public role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(role role) {
        this.role = role;
    }

    /**
     * @return the emprunt
     */
    public Collection<emprunt> getEmprunt() {
        return emprunt;
    }

    /**
     * @param emprunt the emprunt to set
     */
    public void setEmprunt(Collection<emprunt> emprunt) {
        this.emprunt = emprunt;
    }

}

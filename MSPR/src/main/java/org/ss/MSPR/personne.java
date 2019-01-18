package org.ss.MSPR;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class personne {

    private @Id @GeneratedValue Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String visage;
    private String finContrat;
    private String role;

    public personne() {}

    public personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVisage() {
        return visage;
    }

    public void setVisage(String visage) {
        this.visage = visage;
    }

    public String getFinContrat() {
        return finContrat;
    }

    public void setFinContrat(String finContrat) {
        this.finContrat = finContrat;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

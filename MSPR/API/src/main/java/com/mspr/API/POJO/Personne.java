package com.mspr.API.POJO;

import javax.persistence.*;

@Entity
@Table(name = "personne")
public class Personne {

    private long personneId;
    private String adresse;
    private String finContrat;
    private String nom;
    private String prenom;
    private String visage;
    private Long role;

    public Personne() {}

    public Personne(String nom, String prenom) {
    this.prenom = prenom;
    this.nom = nom;
    }

    public Personne(String adresse, String finContrat, String nom, String prenom, String visage, Long role) {
    this.adresse = adresse;
    this.finContrat = finContrat;
    this.nom = nom;
    this.prenom = prenom;
    this.visage = visage;
    this.role = role;
    }

    @Id
    @GeneratedValue
    public long getPersonneId() {
    return personneId;
    }

    public void setPersonneId(long personneId) {
    this.personneId = personneId;
    }

    public String getAdresse() {
    return adresse;
    }

    public void setAdresse(String adresse) {
    this.adresse = adresse;
    }

    public String getFinContrat() {
    return finContrat;
    }

    public void setFinContrat(String finContrat) {
    this.finContrat = finContrat;
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

    public String getVisage() {
    return visage;
    }

    public void setVisage(String visage) {
    this.visage = visage;
    }


    public Long getRole() {
    return role;
    }

    public void setRole(Long role) {
    this.role = role;
    }
}

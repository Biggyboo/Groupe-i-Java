package com.mspr.API.POJO;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
public class Personne {

    private long personneId;
    private String adresse;
    private String finContrat;
    private String nom;
    private String prenom;
    private String visage;
    private String identifiant;
    private String mdp;
    private Long role;

    public Personne() {}

    public Personne(String nom, String prenom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public Personne(String adresse, String finContrat, String nom, String prenom, String visage, Long role, String identifiant, String mdp) {
        this.adresse = adresse;
        this.finContrat = finContrat;
        this.nom = nom;
        this.prenom = prenom;
        this.visage = visage;
        this.role = role;
        this .identifiant = identifiant;
        this.mdp = mdp;
    }

    @Id
    @GeneratedValue(generator = "sequence-personne")
    @GenericGenerator(
            name = "sequence-personne",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "personne_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
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

    /**
     * @return the identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * @param identifiant the identifiant to set
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}

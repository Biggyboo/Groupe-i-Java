package org.ss.MSPR;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class personne {
    @Id
    @GeneratedValue
    @Column(name="personne_id")
    private Long personneId;
    private String nom;
    private String prenom;
    private String visage;
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
    private role role;

    public personne(){
        
    }

    /**
     * @return the personneId
     */
    public Long getPersonneId() {
        return personneId;
    }

    /**
     * @param personneId the personneId to set
     */
    public void setPersonneId(Long personneId) {
        this.personneId = personneId;
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
}
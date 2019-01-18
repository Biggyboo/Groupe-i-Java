package org.ss.MSPR.Personne;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.ss.MSPR.Emprunt.emprunt;
import org.ss.MSPR.Role.role;

@Entity
public class personne implements java.io.Serializable {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String visage;
    private String finContrat;
    private role role;
    private Set<emprunt> emprunt = new HashSet<emprunt>(0);

    public personne() {}

    public personne(String nom, String prenom, Set<emprunt> emprunt, role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.emprunt = emprunt;
    }

    /**
     * @return the id
     */
    @Id 
    @GeneratedValue 
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
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId", nullable = false)
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
    @OneToMany(mappedBy="personne")
	public Set<emprunt> getEmprunt() {
		return emprunt;
	}

	/**
	 * @param emprunt the emprunt to set
	 */
	public void setEmprunt(Set<emprunt> emprunt) {
		this.emprunt = emprunt;
    }  
}

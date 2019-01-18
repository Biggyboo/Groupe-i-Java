package org.ss.MSPR.Role;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.ss.MSPR.Personne.personne;

@Entity
public class role {

    private Long roleId;
    private String libelle;
    private Set<personne> personne = new HashSet<personne>(0);

    public role() {}

    public role(String libelle, Set<personne> personne) {
        this.libelle = libelle;
        this.personne = personne;
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
     * @return the roleId
     */
    @Id 
    @GeneratedValue
    @Column(name="id")
    public Long getRoleId() {
        return roleId;
    }

     /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

	/**
	 * @return the personne
	 */
    @OneToMany(mappedBy="role")
	public Set<personne> getPersonne() {
		return personne;
	}

	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(Set<personne> personne) {
		this.personne = personne;
    }
}

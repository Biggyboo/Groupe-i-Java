package org.ss.MSPR;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class role {
    @Id
    @GeneratedValue
    @Column(name="role_id")
    private Long roleId;
    private String libelle;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<personne> personnes = new HashSet<personne>(0);

    public role() {

    }

    /**
     * @return the roleId
     */
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
     * @return the personnes
     */
    public Set<personne> getPersonnes() {
        return personnes;
    }

    /**
     * @param personnes the personnes to set
     */
    public void setPersonnes(Set<personne> personnes) {
        this.personnes = personnes;
    }
}
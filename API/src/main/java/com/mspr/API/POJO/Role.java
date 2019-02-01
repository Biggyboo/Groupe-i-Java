package com.mspr.API.POJO;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    private long roleId;
    private String libelle;
    //private Collection<Personne> personnes;

    public Role() {
    }

    public Role(String libelle) {
        this.libelle = libelle;
    }

    @Id
    @GeneratedValue
    public long getRoleId() {
    return roleId;
    }

    public void setRoleId(long roleId) {
    this.roleId = roleId;
    }


    public String getLibelle() {
    return libelle;
    }

    public void setLibelle(String libelle) {
    this.libelle = libelle;
    }
}

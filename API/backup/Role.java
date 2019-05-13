package com.mspr.API.POJO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Role {
    private Long roleId;
    private String libelle;
    private Collection<Personne> personnes;

    @Id
    @Column(name = "role_id")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) &&
                Objects.equals(libelle, role.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, libelle);
    }

    @OneToMany(mappedBy = "leRole")
    public Collection<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Collection<Personne> personnes) {
        this.personnes = personnes;
    }
}

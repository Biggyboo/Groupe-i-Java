package com.mspr.API.POJO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Typemateriel {
    private long idType;
    private String libelle;
    private Collection<Materiel> lesMateriels;
    @Id
    @Column(name = "id_type")
    public long getIdType() {
        return idType;
    }

    public void setIdType(long idType) {
        this.idType = idType;
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
        Typemateriel typemateriel = (Typemateriel) o;
        return Objects.equals(idType, typemateriel.idType) &&
                Objects.equals(libelle, typemateriel.libelle) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, libelle);
    }

    @OneToMany(mappedBy = "leType", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<Materiel> getLesMateriels() {
        return lesMateriels;
    }

    public void setLesMateriels(Collection<Materiel> lesMateriels) {
        this.lesMateriels = lesMateriels;
    }
}

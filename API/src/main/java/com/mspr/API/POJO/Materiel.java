package com.mspr.API.POJO;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Materiel {
    private Long materielId;
    private String libelle;
    private String description;
    private Long stock;
    private Collection<Emprunt> lesEmprunts;

    @Id
    @Column(name = "materiel_id")
    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "stock")
    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materiel materiel = (Materiel) o;
        return Objects.equals(materielId, materiel.materielId) &&
                Objects.equals(libelle, materiel.libelle) &&
                Objects.equals(description, materiel.description) &&
                Objects.equals(stock, materiel.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(materielId, libelle, description, stock);
    }

    @OneToMany(mappedBy = "leMateriel", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<Emprunt> getLesEmprunts() {
        return lesEmprunts;
    }

    public void setLesEmprunts(Collection<Emprunt> lesEmprunts) {
        this.lesEmprunts = lesEmprunts;
    }
}

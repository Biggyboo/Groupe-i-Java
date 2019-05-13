package com.mspr.API.POJO;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Materiel {
    private Long id;
    private long idType;
    private Typemateriel leType;
    @Id
    @Column(name = "id", nullable = false, length = 60)
    @GeneratedValue(generator = "sequence-materiel")
    @GenericGenerator(
            name = "sequence-materiel",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "materiel_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Materiel materiel = (Materiel) o;

        if (id != null ? !id.equals(materiel.id) : materiel.id != null) return false;

        return true;
    }
    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id_type",insertable = false,updatable = false)
    public Typemateriel getLeType() {
        return leType;
    }

    public void setLeType(Typemateriel leType) {
        this.leType = leType;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Basic
    @Column(name = "id_type", nullable = false)
    public long getIdType() {
        return idType;
    }

    public void setIdType(long idType) {
        this.idType = idType;
    }
}

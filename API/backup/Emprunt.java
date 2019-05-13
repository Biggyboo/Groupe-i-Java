package com.mspr.API.POJO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Emprunt {
    private Integer quantite;
    private Long empruntId;
    private Date dateDeb;
    private Date dateFin;
    private Boolean rendu;
    private Long materiel;
    private Long personne;
    private Materiel leMateriel;
    private Personne laPersonne;

    @Id
    @Column(name = "emprunt_id")
    @GeneratedValue(generator = "sequence-emprunt")
    @GenericGenerator(
            name = "sequence-emprunt",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "emprunt_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    public Long getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(Long empruntId) {
        this.empruntId = empruntId;
    }

    @Basic
    @Column(name = "date_deb")
    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    @Basic
    @Column(name = "date_fin")
    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Basic
    @Column(name = "rendu")
    public Boolean getRendu() {
        return rendu;
    }

    public void setRendu(Boolean rendu) {
        this.rendu = rendu;
    }

    @Basic
    @Column(name = "quantite")
    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Basic
    @Column(name = "materiel", insertable = false, updatable = false)
    public Long getMateriel() {
        return materiel;
    }

    public void setMateriel(Long materiel) {
        this.materiel = materiel;
    }

    @Basic
    @Column(name = "personne", insertable = false, updatable = false)
    public Long getPersonne() {
        return personne;
    }

    public void setPersonne(Long personne) {
        this.personne = personne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprunt emprunt = (Emprunt) o;
        return Objects.equals(quantite, emprunt.quantite) &&
                Objects.equals(empruntId, emprunt.empruntId) &&
                Objects.equals(dateDeb, emprunt.dateDeb) &&
                Objects.equals(dateFin, emprunt.dateFin) &&
                Objects.equals(rendu, emprunt.rendu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantite, empruntId, dateDeb, dateFin, rendu);
    }

    @ManyToOne
    @JoinColumn(name = "materiel", referencedColumnName = "materiel_id")
    public Materiel getLeMateriel() {
        return leMateriel;
    }

    public void setLeMateriel(Materiel leMateriel) {
        this.leMateriel = leMateriel;
    }

    @ManyToOne
    @JoinColumn(name = "personne", referencedColumnName = "personne_id")
    public Personne getLaPersonne() {
        return laPersonne;
    }

    public void setLaPersonne(Personne laPersonne) {
        this.laPersonne = laPersonne;
    }
}

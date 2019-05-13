package com.mspr.API.POJO;

import javax.persistence.*;

@Entity
@IdClass(EmpruntPK.class)
public class Emprunt {
    private String idMateriel;
    private long idPersonne;
    private boolean rendu;
    private String dateemprunt;
    private String daterendu;
    private Personne laPersonne;
    private Materiel leMateriel;

    @Id
    @Column(name = "id_materiel", nullable = false, length = 60)
    public String getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(String idMateriel) {
        this.idMateriel = idMateriel;
    }

    @Id
    @Column(name = "id_personne", nullable = false)
    public long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(long idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Basic
    @Column(name = "rendu", nullable = false)
    public boolean isRendu() {
        return rendu;
    }

    public void setRendu(boolean rendu) {
        this.rendu = rendu;
    }

    @Id
    @Column(name = "dateemprunt", nullable = false, length = -1)
    public String getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(String dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

    @Basic
    @Column(name = "daterendu", nullable = true, length = -1)
    public String getDaterendu() {
        return daterendu;
    }

    public void setDaterendu(String daterendu) {
        this.daterendu = daterendu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprunt emprunt = (Emprunt) o;

        if (idPersonne != emprunt.idPersonne) return false;
        if (rendu != emprunt.rendu) return false;
        if (idMateriel != null ? !idMateriel.equals(emprunt.idMateriel) : emprunt.idMateriel != null) return false;
        if (dateemprunt != null ? !dateemprunt.equals(emprunt.dateemprunt) : emprunt.dateemprunt != null) return false;
        if (daterendu != null ? !daterendu.equals(emprunt.daterendu) : emprunt.daterendu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMateriel != null ? idMateriel.hashCode() : 0;
        result = 31 * result + (int) (idPersonne ^ (idPersonne >>> 32));
        result = 31 * result + (rendu ? 1 : 0);
        result = 31 * result + (dateemprunt != null ? dateemprunt.hashCode() : 0);
        result = 31 * result + (daterendu != null ? daterendu.hashCode() : 0);
        return result;
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

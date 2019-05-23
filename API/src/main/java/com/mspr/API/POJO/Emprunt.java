package com.mspr.API.POJO;

import javax.persistence.*;

@Entity
public class Emprunt {
    private long idMateriel;
    private long idPersonne;
    private boolean rendu;
    private String dateemprunt;
    private String daterendu;
    private String uuid;
    private Materiel leMateriel;
    private Personne laPersonne;

    @Basic
    @Column(name = "id_materiel", nullable = false,insertable = false,updatable = false)
    public long getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(long idMateriel) {
        this.idMateriel = idMateriel;
    }

    @Basic
    @Column(name = "id_personne", nullable = false,insertable = false,updatable = false)
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

    @Basic
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

    @Id
    @Column(name = "uuid", nullable = false, length = 50)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprunt emprunt = (Emprunt) o;

        if (idMateriel != emprunt.idMateriel) return false;
        if (idPersonne != emprunt.idPersonne) return false;
        if (rendu != emprunt.rendu) return false;
        if (dateemprunt != null ? !dateemprunt.equals(emprunt.dateemprunt) : emprunt.dateemprunt != null) return false;
        if (daterendu != null ? !daterendu.equals(emprunt.daterendu) : emprunt.daterendu != null) return false;
        if (uuid != null ? !uuid.equals(emprunt.uuid) : emprunt.uuid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idMateriel ^ (idMateriel >>> 32));
        result = 31 * result + (int) (idPersonne ^ (idPersonne >>> 32));
        result = 31 * result + (rendu ? 1 : 0);
        result = 31 * result + (dateemprunt != null ? dateemprunt.hashCode() : 0);
        result = 31 * result + (daterendu != null ? daterendu.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }
    @ManyToOne
    @JoinColumn(name = "id_materiel",referencedColumnName = "materiel_id")
    public Materiel getLeMateriel() {
        return leMateriel;
    }

    public void setLeMateriel(Materiel leMateriel) {
        this.leMateriel = leMateriel;
    }
    @ManyToOne
    @JoinColumn(name = "id_personne",referencedColumnName = "personne_id")
    public Personne getLaPersonne() {
        return laPersonne;
    }

    public void setLaPersonne(Personne laPersonne) {
        this.laPersonne = laPersonne;
    }
}

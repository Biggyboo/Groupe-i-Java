package com.mspr.API.POJO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmpruntPK implements Serializable {
    private String idMateriel;
    private long idPersonne;
    private String dateemprunt;

    @Column(name = "id_materiel", nullable = false, length = 60)
    @Id
    public String getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(String idMateriel) {
        this.idMateriel = idMateriel;
    }

    @Column(name = "id_personne", nullable = false)
    @Id
    public long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(long idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Column(name = "dateemprunt", nullable = false, length = -1)
    @Id
    public String getDateemprunt() {
        return dateemprunt;
    }

    public void setDateemprunt(String dateemprunt) {
        this.dateemprunt = dateemprunt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpruntPK empruntPK = (EmpruntPK) o;

        if (idPersonne != empruntPK.idPersonne) return false;
        if (idMateriel != null ? !idMateriel.equals(empruntPK.idMateriel) : empruntPK.idMateriel != null) return false;
        if (dateemprunt != null ? !dateemprunt.equals(empruntPK.dateemprunt) : empruntPK.dateemprunt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMateriel != null ? idMateriel.hashCode() : 0;
        result = 31 * result + (int) (idPersonne ^ (idPersonne >>> 32));
        result = 31 * result + (dateemprunt != null ? dateemprunt.hashCode() : 0);
        return result;
    }
}

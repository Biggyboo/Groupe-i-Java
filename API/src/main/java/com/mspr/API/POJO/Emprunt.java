package com.mspr.API.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {

  private long quantite;
  private long empruntId;
  private java.sql.Timestamp dateDeb;
  private java.sql.Timestamp dateFin;
  private long materiel;
  private long personne;

  public long getQuantite() {
    return quantite;
  }

  public void setQuantite(long quantite) {
    this.quantite = quantite;
  }

  @Id
  @GeneratedValue
  public long getEmpruntId() {
    return empruntId;
  }

  public void setEmpruntId(long empruntId) {
    this.empruntId = empruntId;
  }


  public java.sql.Timestamp getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(java.sql.Timestamp dateDeb) {
    this.dateDeb = dateDeb;
  }


  public java.sql.Timestamp getDateFin() {
    return dateFin;
  }

  public void setDateFin(java.sql.Timestamp dateFin) {
    this.dateFin = dateFin;
  }


  public long getMateriel() {
    return materiel;
  }

  public void setMateriel(long materiel) {
    this.materiel = materiel;
  }


  public long getPersonne() {
    return personne;
  }

  public void setPersonne(long personne) {
    this.personne = personne;
  }

}

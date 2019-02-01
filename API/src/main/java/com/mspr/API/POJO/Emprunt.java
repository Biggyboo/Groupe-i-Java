package com.mspr.API.POJO;

<<<<<<< HEAD
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

>>>>>>> parent of ce36576... modif
@Entity
@Table(name = "emprunt")
public class Emprunt {

  private long quantite;
  private long empruntId;
<<<<<<< HEAD
  private Date dateDeb;
  private Date dateFin;
  private long materiel;
  private long personne;
  private boolean rendu;
=======
  private java.sql.Timestamp dateDeb;
  private java.sql.Timestamp dateFin;
  private long materiel;
  private long personne;
>>>>>>> parent of ce36576... modif

  public long getQuantite() {
    return quantite;
  }

  public void setQuantite(long quantite) {
    this.quantite = quantite;
  }

  @Id
<<<<<<< HEAD
  @GeneratedValue(strategy = GenerationType.AUTO)
=======
  @GeneratedValue
>>>>>>> parent of ce36576... modif
  public long getEmpruntId() {
    return empruntId;
  }

  public void setEmpruntId(long empruntId) {
    this.empruntId = empruntId;
  }

<<<<<<< HEAD
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = DateDeserializer.class, as=Date.class)
  public Date getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(Date dateDeb) {
    this.dateDeb = dateDeb;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = DateDeserializer.class, as=Date.class)
  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
=======

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
>>>>>>> parent of ce36576... modif
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

<<<<<<< HEAD
  public boolean isRendu() {
    return rendu;
  }

  public void setRendu(boolean rendu) {
    this.rendu = rendu;
  }

=======
>>>>>>> parent of ce36576... modif
}

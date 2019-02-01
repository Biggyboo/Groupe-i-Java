package com.mspr.API.POJO;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {

  private long quantite;
  private long empruntId;
  private Date dateDeb;
  private Date dateFin;
  private long materiel;
  private long personne;
  private boolean rendu;

  public long getQuantite() {
    return quantite;
  }

  public void setQuantite(long quantite) {
    this.quantite = quantite;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long getEmpruntId() {
    return empruntId;
  }

  public void setEmpruntId(long empruntId) {
    this.empruntId = empruntId;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = DateDeserializer.class, as = Date.class)
  public Date getDateDeb() {
    return dateDeb;
  }

  public void setDateDeb(Date dateDeb) {
    this.dateDeb = dateDeb;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @JsonDeserialize(using = DateDeserializer.class, as = Date.class)
  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {

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

  public boolean isRendu() {
    return rendu;
  }

  public void setRendu(boolean rendu) {
    this.rendu = rendu;
  }
}

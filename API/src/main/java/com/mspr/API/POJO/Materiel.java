package com.mspr.API.POJO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiel")
public class Materiel {

  private long materielId;
  private String libelle;
  private String description;
  private long stock;

  @Id
  @GeneratedValue
  public long getMaterielId() {
    return materielId;
  }

  public void setMaterielId(long materielId) {
    this.materielId = materielId;
  }


  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getStock() {
    return stock;
  }

  public void setStock(long stock) {
    this.stock = stock;
  }

}

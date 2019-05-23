package com.mspr.API.POJO;

import com.mspr.API.configuration.RepoConfig;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.*;

@Entity
public class Personne {
    private Long personneId;
    private String adresse;
    private String finContrat;
    private String nom;
    private String prenom;
    private String identifiant;
    private String visage;
    private Long role;
    private Collection<Emprunt> lesEmprunts;
    private Role leRole;

    @Id
    @Column(name = "personne_id")
    @GeneratedValue(generator = "sequence-personne")
    @GenericGenerator(
            name = "sequence-personne",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "personne_sequence"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    public Long getPersonneId() {
        return personneId;
    }

    public void setPersonneId(Long personneId) {
        this.personneId = personneId;
    }

    @Basic
    @Column(name = "adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Basic
    @Column(name = "fin_contrat")
    public String getFinContrat() {
        return finContrat;
    }

    public void setFinContrat(String finContrat) {
        this.finContrat = finContrat;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "identifiant")
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "visage")
    public String getVisage() {
        return visage;
    }

    public void setVisage(String visage) {
        this.visage = visage;
    }

    @Basic
    @Column(name = "role", insertable = false, updatable = false)
    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(personneId, personne.personneId) &&
                Objects.equals(adresse, personne.adresse) &&
                Objects.equals(finContrat, personne.finContrat) &&
                Objects.equals(nom, personne.nom) &&
                Objects.equals(prenom, personne.prenom) &&
                Objects.equals(identifiant, personne.identifiant) &&
                Objects.equals(visage, personne.visage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personneId, adresse, finContrat, nom, prenom, identifiant, visage);
    }

    @OneToMany(mappedBy = "laPersonne", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<Emprunt> getLesEmprunts() {
        return lesEmprunts;
    }

    public void setLesEmprunts(Collection<Emprunt> lesEmprunts) {
        this.lesEmprunts = lesEmprunts;
    }

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    public Role getLeRole() {
        return leRole;
    }

    public void setLeRole(Role leRole) {
        this.leRole = leRole;
    }

    public Personne findPersonneByIdentifiant(String identifiant) {
        PersonneRepo accountRepository = (PersonneRepo) RepoConfig.contextProvider().getApplicationContext().getBean("personneRepo");
        return accountRepository.findPersonneByIdentifiant(identifiant);
    }
}

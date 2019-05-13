package com.mspr.API.POJO;

import org.springframework.data.annotation.Persistent;

@Persistent
public class MaterielStat {
    private Long id;
    private int qte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MaterielStat(Long id, int qte) {
        this.id = id;
        this.qte = qte;
    }

    public MaterielStat(Long id, Long qte) {
        this.id = id;
        this.qte = qte.intValue();
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}

package com.mspr.API.POJO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
public interface MaterielRepo extends CrudRepository<Materiel, Long> {
    @Query("SELECT new com.mspr.API.POJO.MaterielStat( m.materielId, (m.stock - SUM(e.quantite))) from Materiel m JOIN Emprunt e on m.materielId = e.materiel group by m.materielId, m.stock")
    List<MaterielStat> listMaterielLeftQty();

    @Query( value = "SELECT coalesce((materiel.stock - SUM(emprunt.quantite)), materiel.stock)as qteEmprunt\n" +
            "from materiel LEFT JOIN emprunt on materiel.materiel_id = emprunt.materiel\n" +
            "where materiel_id = ?1\n" +
            "and emprunt.rendu = false\n" +
            "GROUP BY stock",
            nativeQuery = true)
    Long countMaterielLeftQtyById(int id);

    @Query(value = "SELECT COUNT(*)\n" +
            "FROM (SELECT materiel_id, (m.stock - SUM(e.quantite)) as qte\n" +
            "from Materiel m\n" +
            "    JOIN Emprunt e on m.materiel_id = e.materiel\n" +
            "where e.rendu = false\n" +
            "group by materiel_id\n" +
            "having (m.stock - SUM(e.quantite)) = 0) as t", nativeQuery = true)
    Long countMaterielNoQtyLeft();
}
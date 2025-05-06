package com.example.demoKDLv1.Layer_Entity.MatHangDuocDat;

import java.util.List;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MatHangDuocDat_RepoEMJ {
    @PersistenceContext
    private EntityManager entityManager;

    public List<MatHangDuocDat> getRandomMhdd(Integer soluong){
        String jpqlString = "SELECT m FROM MatHangDuocDat m ORDER BY FUNCTION('NEWID')";

        List<MatHangDuocDat> listMhdd = 
            entityManager
                .createQuery(jpqlString, MatHangDuocDat.class)
                .setMaxResults(soluong)
                .getResultList();

        return listMhdd;
    }
}

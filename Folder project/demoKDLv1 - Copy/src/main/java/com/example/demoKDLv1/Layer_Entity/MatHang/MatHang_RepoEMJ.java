package com.example.demoKDLv1.Layer_Entity.MatHang;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MatHang_RepoEMJ {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MatHang> getRandomMatHang(Integer soluong){
        String jpqlString = "SELECT m FROM MatHang m ORDER BY FUNCTION('NEWID')";

        List<MatHang> listMh = 
            entityManager
                .createQuery(jpqlString, MatHang.class)
                .setMaxResults(soluong)
                .getResultList();

        return listMh;
    }
}

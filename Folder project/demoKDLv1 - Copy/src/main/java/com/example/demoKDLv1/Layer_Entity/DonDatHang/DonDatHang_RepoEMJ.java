package com.example.demoKDLv1.Layer_Entity.DonDatHang;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class DonDatHang_RepoEMJ {
    @PersistenceContext
    private EntityManager entityManager;

    public List<DonDatHang> getRandomDonDatHang(Integer soLuong){
        String jpqlString = "SELECT d FROM DonDatHang d ORDER BY FUNCTION('NEWID')";

        List<DonDatHang> listDdh=
            entityManager
                .createQuery(jpqlString, DonDatHang.class)
                .setMaxResults(soLuong)
                .getResultList();

        return listDdh;
    }
}

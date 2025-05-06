package com.example.demoKDLv1.Layer_Entity.KhachHangDuLich;

import java.util.List;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class KhachHangDuLich_RepoEMJ {

    @PersistenceContext
    private EntityManager entityManager;

    public List<KhachHangDuLich> getRandomKhdl(Integer soluong){
        String jpqlString = "SELECT k FROM KhachHangDuLich k ORDER BY FUNCTION('NEWID')";

        List<KhachHangDuLich> listKhdl = 
            entityManager
                .createQuery(jpqlString, KhachHangDuLich.class)
                .setMaxResults(soluong)
                .getResultList();

        return listKhdl;
    }
}

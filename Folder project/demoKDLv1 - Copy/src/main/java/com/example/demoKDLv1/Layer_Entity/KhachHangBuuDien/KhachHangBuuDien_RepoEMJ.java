package com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien;

import java.util.List;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class KhachHangBuuDien_RepoEMJ {
    @PersistenceContext
    private EntityManager entityManager;

    public List<KhachHangBuuDien> getRandomKhbd(Integer soluong){
        String jpqlString = "SELECT k FROM KhachHangBuuDien k ORDER BY FUNCTION('NEWID')";

        List<KhachHangBuuDien> listKhbd = 
            entityManager
                .createQuery(jpqlString, KhachHangBuuDien.class)
                .setMaxResults(soluong)
                .getResultList();

        return listKhbd;
    }
}

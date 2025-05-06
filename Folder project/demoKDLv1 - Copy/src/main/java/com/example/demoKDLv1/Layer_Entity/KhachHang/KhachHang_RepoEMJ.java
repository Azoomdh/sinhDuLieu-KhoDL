package com.example.demoKDLv1.Layer_Entity.KhachHang;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class KhachHang_RepoEMJ {

    @PersistenceContext
    private EntityManager entityManager;

    public List<KhachHang> getRandomKhachHang(Integer soLuong){
        String jpqlString = "SELECT k FROM KhachHang k ORDER BY FUNCTION('NEWID')";

        List<KhachHang> listKh =
            entityManager
                .createQuery(jpqlString, KhachHang.class)
                .setMaxResults(soLuong)
                .getResultList();

        return listKh;
    }
}

package com.example.demoKDLv1.Layer_Entity.CuaHang;

import java.util.List;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CuaHang_RepoEMJ {
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<CuaHang> getRandomCuaHang(Integer soLuong){
        String jpqlString = "SELECT c FROM CuaHang c ORDER BY FUNCTION('NEWID')";

        List<CuaHang> listCh = 
            entityManager
                .createQuery(jpqlString, CuaHang.class)
                .setMaxResults(soLuong)
                .getResultList();

        return listCh;
    }
}

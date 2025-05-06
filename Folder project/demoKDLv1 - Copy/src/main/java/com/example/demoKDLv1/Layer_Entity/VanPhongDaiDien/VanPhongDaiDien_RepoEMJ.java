package com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demoKDLv1.Layer_Entity.MatHang.MatHang;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class VanPhongDaiDien_RepoEMJ {

    @PersistenceContext
    private EntityManager entityManager;

    public List<VanPhongDaiDien> getRandomVpdd(Integer soluong){
        String jpqlString = "SELECT v FROM VanPhongDaiDien v ORDER BY FUNCTION('NEWID')";

        List<VanPhongDaiDien> listVpdd = 
            entityManager
                .createQuery(jpqlString, VanPhongDaiDien.class)
                .setMaxResults(soluong)
                .getResultList();

        return listVpdd;
    }
}

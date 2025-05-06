package com.example.demoKDLv1.Layer_Entity.MatHangDuocLuuTru;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demoKDLv1.Layer_Entity.MatHang.MatHang;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MatHangDuocLuuTru_RepoEMJ {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MatHangDuocLuuTru> getRandomMhdlt(Integer soluong){
        String jpqlString = "SELECT m FROM MatHangDuocLuuTru m ORDER BY FUNCTION('NEWID')";

        List<MatHangDuocLuuTru> listMhdlt = 
            entityManager
                .createQuery(jpqlString, MatHangDuocLuuTru.class)
                .setMaxResults(soluong)
                .getResultList();

        return listMhdlt;
    }
}

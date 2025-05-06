package com.example.demoKDLv1.Layer_Entity.CuaHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.LockModeType;

@Transactional
@Repository
public interface CuaHang_Repo 
    extends JpaRepository<CuaHang, Long>
{
    
}

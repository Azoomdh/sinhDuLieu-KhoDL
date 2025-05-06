package com.example.demoKDLv1.Layer_Entity.DonDatHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface DonDatHang_Repo 
    extends JpaRepository<DonDatHang, Long>
{
    
}

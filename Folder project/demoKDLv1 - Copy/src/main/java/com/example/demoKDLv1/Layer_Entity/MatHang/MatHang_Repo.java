package com.example.demoKDLv1.Layer_Entity.MatHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface MatHang_Repo 
    extends JpaRepository<MatHang, Long>
{

}

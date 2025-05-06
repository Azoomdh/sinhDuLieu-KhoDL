package com.example.demoKDLv1.Layer_Entity.MatHangDuocLuuTru;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface MatHangDuocLuuTru_Repo 
    extends JpaRepository<MatHangDuocLuuTru, MatHangDuocLuuTru_Key>
{

}
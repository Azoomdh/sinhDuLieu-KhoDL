package com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface VanPhongDaiDien_Repo 
    extends JpaRepository<VanPhongDaiDien, Long>
{

}

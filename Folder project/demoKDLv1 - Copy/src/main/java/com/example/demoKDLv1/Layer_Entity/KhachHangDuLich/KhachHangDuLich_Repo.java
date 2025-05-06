package com.example.demoKDLv1.Layer_Entity.KhachHangDuLich;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface KhachHangDuLich_Repo 
    extends JpaRepository<KhachHangDuLich, Long>
{

}

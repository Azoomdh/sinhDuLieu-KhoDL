package com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface KhachHangBuuDien_Repo 
    extends JpaRepository<KhachHangBuuDien, Long>
{

}

package com.example.demoKDLv1.Layer_Entity.KhachHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;


@Transactional
@Repository
public interface KhachHang_Repo 
    extends JpaRepository<KhachHang, Long>
{

}

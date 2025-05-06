package com.example.demoKDLv1.Layer_Faker.FakerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien.KhachHangBuuDien;
import com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien.KhachHangBuuDien_Service;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;
import com.example.demoKDLv1.Layer_Faker.FakerEntity.KhachHangBuuDienFaker;


// @Transactional
@Service
public class KhachHangBuuDienFS {
    @Autowired
    private AllEntityConfig allEntityConfig;

    @Autowired
    private KhachHangBuuDien_Service khbd_Service;

    public KhachHangBuuDien createKhbd(KhachHang kh1){
        KhachHangBuuDien khbd1= KhachHangBuuDienFaker.createFakeKhbd(kh1);

        khbd1 = this.khbd_Service.createKhbd(khbd1);

        return khbd1;
    }

}

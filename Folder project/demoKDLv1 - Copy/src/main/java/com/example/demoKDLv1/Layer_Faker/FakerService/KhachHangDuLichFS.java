package com.example.demoKDLv1.Layer_Faker.FakerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Entity.KhachHangDuLich.KhachHangDuLich;
import com.example.demoKDLv1.Layer_Entity.KhachHangDuLich.KhachHangDuLich_Service;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;
import com.example.demoKDLv1.Layer_Faker.FakerEntity.KhachHangDuLichFaker;


// @Transactional
@Service
public class KhachHangDuLichFS {
    @Autowired
    private AllEntityConfig allEntityConfig;

    @Autowired
    private KhachHangDuLich_Service khdl_Service;

    public KhachHangDuLich createKhdl(KhachHang kh1){
        KhachHangDuLich khdl1 = KhachHangDuLichFaker.createFakeKhdl(kh1);

        khdl1 = this.khdl_Service.createKhdl(khdl1);

        return khdl1;
    }
}

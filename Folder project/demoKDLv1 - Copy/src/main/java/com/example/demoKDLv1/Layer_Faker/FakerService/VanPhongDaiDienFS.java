package com.example.demoKDLv1.Layer_Faker.FakerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoKDLv1.Layer_Entity.CuaHang.CuaHang;
import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien.KhachHangBuuDien;
import com.example.demoKDLv1.Layer_Entity.KhachHangDuLich.KhachHangDuLich;
import com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien.VanPhongDaiDien;
import com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien.VanPhongDaiDien_Service;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;
import com.example.demoKDLv1.Layer_Faker.FakerEntity.VanPhongDaiDienFaker;


// @Transactional
@Service
public class VanPhongDaiDienFS {
    @Autowired
    private AllEntityConfig allEntityConfig;

    @Autowired
    private VanPhongDaiDien_Service vpdd_Service;

    @Autowired
    private KhachHangFS kh_FS;

    @Autowired
    private CuaHangFS ch_FS;

    @Autowired
    private KhachHangBuuDienFS khbd_FS;

    @Autowired
    private KhachHangDuLichFS khdl_FS;

    public VanPhongDaiDien createVpdd(){
        VanPhongDaiDien vpdd1= VanPhongDaiDienFaker.createFakeVpdd(this.allEntityConfig);

        vpdd1 = this.vpdd_Service.createVpdd(vpdd1);

        List<KhachHang> listKhachHangOfVpdd = this.kh_FS.createKhachHang(vpdd1, this.allEntityConfig.getVpdd().getSoKhachhang().getGiaTri());

        List<CuaHang> listCuahangOfVpdd = this.ch_FS.createCuaHang(vpdd1, this.allEntityConfig.getVpdd().getSoCuahang().getGiaTri());

        return vpdd1;
    }

    public List<VanPhongDaiDien> createVpdd(Integer soLuong){
        List<VanPhongDaiDien> listVpdd= new ArrayList<>();

        for(int i=0; i< soLuong; i++){
            VanPhongDaiDien vpdd1= this.createVpdd();

            listVpdd.add(vpdd1);
        }

        return listVpdd;
    }
}

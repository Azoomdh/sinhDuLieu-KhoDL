package com.example.demoKDLv1.Layer_Faker.FakerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoKDLv1.Layer_Entity.DonDatHang.DonDatHang;
import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang_Service;
import com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien.KhachHangBuuDien;
import com.example.demoKDLv1.Layer_Entity.KhachHangDuLich.KhachHangDuLich;
import com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien.VanPhongDaiDien;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;
import com.example.demoKDLv1.Layer_Faker.FakerEntity.KhachHangFaker;



// @Transactional
@Service
public class KhachHangFS {
    @Autowired
    private AllEntityConfig allEntityConfig;

    @Autowired
    private KhachHang_Service kh_Service;

    @Autowired
    private DonDatHangFS ddh_FS;

    @Autowired
    private KhachHangDuLichFS khdl_FS;

    @Autowired
    private KhachHangBuuDienFS khbd_FS;

    public KhachHang createKhachhang(VanPhongDaiDien vpdd1){
        KhachHang kh1 = KhachHangFaker.createFakeKhachhang(vpdd1, this.allEntityConfig);

        // 🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩
        KhachHangDuLich khdl= null;
        KhachHangBuuDien khbd= null;

        Integer chooseNumber = new Random().nextInt(0, 10);

        if(chooseNumber < 5){
            khbd = this.khbd_FS.createKhbd(kh1);

            kh1= this.kh_Service.getKhachhangById(khbd.getMaKH());
        }

        else{
            khdl = this.khdl_FS.createKhdl(kh1);

            kh1= this.kh_Service.getKhachhangById(khdl.getMaKH());
        }
        // 🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩 

        // kh1 = this.kh_Service.createKhachhang(kh1);

        List<DonDatHang> listDdh= 
            this.ddh_FS.createDdh(
                kh1, 
                allEntityConfig.getKhachhang().getSoDdh().getGiaTri()
            );



        return kh1;
    }

    public List<KhachHang> createKhachHang(VanPhongDaiDien vpdd1, Integer soLuong){
        List<KhachHang> listKH= new ArrayList<>();

        for(int i=0; i< soLuong; i++){
            KhachHang kh1= this.createKhachhang(vpdd1);

            listKH.add(kh1);
        }

        return listKH;
    }
}

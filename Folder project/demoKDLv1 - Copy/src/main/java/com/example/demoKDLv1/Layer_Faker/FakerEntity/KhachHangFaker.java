package com.example.demoKDLv1.Layer_Faker.FakerEntity;

import java.sql.Timestamp;

import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien.VanPhongDaiDien;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;
import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class KhachHangFaker {
    public static KhachHang createFakeKhachhang(VanPhongDaiDien vpdd1, AllEntityConfig allConfig){
        Long maKH= null;
        String tenKH= null;
        Timestamp ngaydathangdautien = null;
        VanPhongDaiDien vpdd = null;

        maKH= null;
        tenKH = Faker_Util.getFullName();
        ngaydathangdautien = allConfig.getKhachhang().getNgaydathangdautien().getGiaTri();
        vpdd = vpdd1;

        KhachHang kh1 = new KhachHang(maKH, tenKH, ngaydathangdautien, vpdd);

        return kh1;
    }
}

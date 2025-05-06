package com.example.demoKDLv1.Layer_Faker.FakerEntity;

import java.sql.Timestamp;

import com.example.demoKDLv1.Layer_Entity.CuaHang.CuaHang;
import com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien.VanPhongDaiDien;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;
import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class CuaHangFaker {
    public static CuaHang createFakeCuaHang(VanPhongDaiDien vpdd1, AllEntityConfig allConfig){
        Long maCH= null;
        String soDT= null;
        Timestamp thoigianlapvanphong= null;
        VanPhongDaiDien vpdd= null;

        maCH =null;
        soDT= Faker_Util.getSdt();
        thoigianlapvanphong = allConfig.getVpdd().getThoigianlapvanphong().getGiaTri();
        vpdd = vpdd1;

        CuaHang ch1= new CuaHang(maCH, soDT, thoigianlapvanphong, vpdd);

        return ch1;
    }
}

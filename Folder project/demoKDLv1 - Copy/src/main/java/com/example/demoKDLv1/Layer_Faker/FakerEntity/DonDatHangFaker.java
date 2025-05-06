package com.example.demoKDLv1.Layer_Faker.FakerEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.demoKDLv1.Layer_Entity.DonDatHang.DonDatHang;
import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;

import lombok.Data;

@Data
public class DonDatHangFaker {
    public static DonDatHang createFakeDdh(KhachHang kh1, AllEntityConfig allConfig){
        Long madon= null;
        KhachHang kh= null;
        Timestamp ngaydathang = null;

        madon = null;
        kh = kh1;
        ngaydathang = allConfig.getDdh().getNgaydathang().getGiaTri();

        DonDatHang ddh1 = new DonDatHang(madon, kh, ngaydathang);

        return ddh1;
    }

    public static List<DonDatHang> createFakeDdh(List<KhachHang> listKh, AllEntityConfig allConfig){
        List<DonDatHang> listDdh= new ArrayList<>();

        for(KhachHang kh1 : listKh){
            DonDatHang ddh1 = DonDatHangFaker.createFakeDdh(kh1, allConfig);

            listDdh.add(ddh1);
        }

        return listDdh;
    }
}

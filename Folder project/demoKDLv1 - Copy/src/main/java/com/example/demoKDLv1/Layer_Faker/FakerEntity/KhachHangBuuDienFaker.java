package com.example.demoKDLv1.Layer_Faker.FakerEntity;

import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien.KhachHangBuuDien;
import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class KhachHangBuuDienFaker {
    public static KhachHangBuuDien createFakeKhbd(KhachHang kh1){
        String diachibuudien= Faker_Util.getDiachibuudien();

        KhachHangBuuDien khbd= new KhachHangBuuDien(kh1, diachibuudien);

        return khbd;
    }
}

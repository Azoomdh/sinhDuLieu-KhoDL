package com.example.demoKDLv1.Layer_Faker.FakerEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.demoKDLv1.Layer_Entity.CuaHang.CuaHang;
import com.example.demoKDLv1.Layer_Entity.MatHang.MatHang;
import com.example.demoKDLv1.Layer_Entity.MatHangDuocLuuTru.MatHangDuocLuuTru;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig.AllEntityConfig;

import lombok.Data;

@Data
public class MatHangDuocLuuTruFaker {
    public static MatHangDuocLuuTru createFakeMhdlt(CuaHang ch1, MatHang mh1, AllEntityConfig allEntityConfig){
        CuaHang cuaHang= null;
        MatHang matHang= null;
        Integer soluongtrongkho= null;
        Timestamp thoigianluutru= null;

        cuaHang = ch1;
        matHang = mh1;
        soluongtrongkho = allEntityConfig.getMhdlt().getSoluongtrongkho().getGiaTri();
        thoigianluutru = allEntityConfig.getMhdlt().getThoigianluutru().getGiaTri();

        MatHangDuocLuuTru mhdlt1 = new MatHangDuocLuuTru(cuaHang, matHang, soluongtrongkho, thoigianluutru);

        return mhdlt1;
    }

    public static List<MatHangDuocLuuTru> createFakeMhdlt(CuaHang ch1, List<MatHang> listMh1, AllEntityConfig allEntityConfig){
        List<MatHangDuocLuuTru> listMhdlt1= new ArrayList<>();

        for(MatHang mh1 : listMh1){
            MatHangDuocLuuTru mhdlt1= MatHangDuocLuuTruFaker.createFakeMhdlt(ch1, mh1, allEntityConfig);

            listMhdlt1.add(mhdlt1);
        }

        return listMhdlt1;
    }
}

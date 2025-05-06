package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.GiaConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.NgayConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SizeConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SoluongConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.TrongluongConfigDetail;

import lombok.Data;

@Data
@Component
public class AllEntityConfig {
    private CuaHangConfig cuahang;
    private DonDatHangConfig ddh;
    private KhachHangConfig khachhang;
    private MatHangConfig mathang;
    private MatHangDuocDatConfig mhdd;
    private MatHangDuocLuuTruConfig mhdlt;
    private VanPhongDaiDienConfig vpdd;
    private Boolean nowMode;
    


    public AllEntityConfig(){
        this.nowMode= false;

        NgayConfigDetail cuahang_thoigianmoban= new NgayConfigDetail("01:01:2020 00:00:00", "01:01:2025 00:00:00", nowMode);
        SoluongConfigDetail cuahang_soMhdlt = new SoluongConfigDetail(70, 80);
        this.cuahang = new CuaHangConfig(cuahang_thoigianmoban, cuahang_soMhdlt);


        SoluongConfigDetail ddh_soMhdd = new SoluongConfigDetail(2, 7);
        NgayConfigDetail ddh_ngaydathang = new NgayConfigDetail("01:01:2020 00:00:00", "01:01:2025 00:00:00", nowMode);
        this.ddh = new DonDatHangConfig(ddh_soMhdd, ddh_ngaydathang);

        NgayConfigDetail kh_ngaydathangdautien = new NgayConfigDetail("01:01:2020 00:00:00", "01:01:2025 00:00:00", nowMode);
        SoluongConfigDetail kh_soDdh = new SoluongConfigDetail(1, 10);
        this.khachhang = new KhachHangConfig(kh_ngaydathangdautien, kh_soDdh);

        NgayConfigDetail mh_thoigiannhaphang= new NgayConfigDetail("01:01:2020 00:00:00", "01:01:2025 00:00:00", nowMode);
        GiaConfigDetail mh_gia= new GiaConfigDetail(Long.parseLong("70000"), Long.parseLong("100000") );
        TrongluongConfigDetail mh_trongluong = new TrongluongConfigDetail(0.1, 10.0);
        ArrayList<String> listSize= new ArrayList<>( Arrays.asList("XXS", "XS", "S", "M", "L", "XL", "XXL"));
        SizeConfigDetail mh_size = new SizeConfigDetail( listSize);
        this.mathang= new MatHangConfig(mh_thoigiannhaphang, mh_gia, mh_trongluong, mh_size);

        SoluongConfigDetail mhdd_soluongdat= new SoluongConfigDetail(1, 7);
        this.mhdd = new MatHangDuocDatConfig(mhdd_soluongdat);

        SoluongConfigDetail mhdlt_soluongtrongkho = new SoluongConfigDetail(200, 400);
        NgayConfigDetail mhdlt_thoigianluutru = new NgayConfigDetail("01:01:2020 00:00:00", "01:01:2025 00:00:00", nowMode);
        this.mhdlt = new MatHangDuocLuuTruConfig(mhdlt_soluongtrongkho, mhdlt_thoigianluutru);

        NgayConfigDetail vpdd_thoigianlapvanphong = new NgayConfigDetail("01:01:2020 00:00:00", "01:01:2025 00:00:00", nowMode);
        SoluongConfigDetail vpdd_soCuahang = new SoluongConfigDetail(10, 20);
        SoluongConfigDetail vpdd_soKhachhang = new SoluongConfigDetail(100, 150);
        this.vpdd = new VanPhongDaiDienConfig(vpdd_thoigianlapvanphong, vpdd_soCuahang, vpdd_soKhachhang);
    
    }

    public AllEntityConfig
        (   
            CuaHangConfig cuahang, DonDatHangConfig ddh, KhachHangConfig khachhang,
            MatHangConfig mathang, MatHangDuocDatConfig mhdd, MatHangDuocLuuTruConfig mhdlt,
            VanPhongDaiDienConfig vpdd
        ) 
        
        {
            this.cuahang = cuahang;
            this.ddh = ddh;
            this.khachhang = khachhang;
            this.mathang = mathang;
            this.mhdd = mhdd;
            this.mhdlt = mhdlt;
            this.vpdd = vpdd;
        }

    
}

package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.NgayConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SoluongConfigDetail;

import lombok.Data;

@Data
public class VanPhongDaiDienConfig {
    private NgayConfigDetail thoigianlapvanphong;
    private SoluongConfigDetail soCuahang;
    private SoluongConfigDetail soKhachhang;
    // private SoluongConfigDetail soKhbd;
    // private SoluongConfigDetail soKhdl;
    
    public VanPhongDaiDienConfig() {
        // ...
    }

    public VanPhongDaiDienConfig(NgayConfigDetail thoigianlapvanphong, SoluongConfigDetail soCuahang,
            SoluongConfigDetail soKhachhang) {
        this.thoigianlapvanphong = thoigianlapvanphong;
        this.soCuahang = soCuahang;
        this.soKhachhang = soKhachhang;
    }



}

package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.NgayConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SoluongConfigDetail;

import lombok.Data;

@Data
public class DonDatHangConfig {
    private SoluongConfigDetail soMhdd;
    private NgayConfigDetail ngaydathang;
    
    public DonDatHangConfig() {
        //...
    }
    
    public DonDatHangConfig(SoluongConfigDetail soMhdd, NgayConfigDetail ngaydathang) {
        this.soMhdd = soMhdd;
        this.ngaydathang = ngaydathang;
    }

    
}

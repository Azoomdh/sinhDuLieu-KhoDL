package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.NgayConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SoluongConfigDetail;

import lombok.Data;

@Data
public class KhachHangConfig {
    private NgayConfigDetail ngaydathangdautien;
    private SoluongConfigDetail soDdh;

    public KhachHangConfig() {
        //...
    }

    public KhachHangConfig
        (NgayConfigDetail ngaydathangdautien, SoluongConfigDetail soDdh) 
            {
        this.ngaydathangdautien = ngaydathangdautien;
        this.soDdh = soDdh;
    }

    
}

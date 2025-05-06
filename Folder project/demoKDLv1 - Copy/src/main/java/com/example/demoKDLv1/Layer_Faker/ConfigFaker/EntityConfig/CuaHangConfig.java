package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.NgayConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SoluongConfigDetail;

import lombok.Data;

@Data
public class CuaHangConfig {
    private NgayConfigDetail thoigianmoban;
    private SoluongConfigDetail soMhdlt;
    
    public CuaHangConfig() {
        // ...
    }

    public CuaHangConfig(NgayConfigDetail thoigianmoban, SoluongConfigDetail soMhdlt) {
        this.thoigianmoban = thoigianmoban;
        this.soMhdlt = soMhdlt;
    }

    
}

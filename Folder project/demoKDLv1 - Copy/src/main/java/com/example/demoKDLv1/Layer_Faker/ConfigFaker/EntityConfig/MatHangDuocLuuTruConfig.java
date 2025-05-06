package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.NgayConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SoluongConfigDetail;

import lombok.Data;

@Data
public class MatHangDuocLuuTruConfig {
    private SoluongConfigDetail soluongtrongkho;
    private NgayConfigDetail thoigianluutru;
    
    public MatHangDuocLuuTruConfig() {
        // ...
    }

    public MatHangDuocLuuTruConfig
        (SoluongConfigDetail soluongtrongkho, NgayConfigDetail thoigianluutru) 
            {
        this.soluongtrongkho = soluongtrongkho;
        this.thoigianluutru = thoigianluutru;
    }

    
}

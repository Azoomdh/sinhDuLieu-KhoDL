package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SoluongConfigDetail;

import lombok.Data;

@Data
public class MatHangDuocDatConfig {
    private SoluongConfigDetail soluongdat;

    public MatHangDuocDatConfig() {
        // ...
    }

    public MatHangDuocDatConfig(SoluongConfigDetail soluongdat) {
        this.soluongdat = soluongdat;
    }

}

package com.example.demoKDLv1.Layer_Faker.ConfigFaker.EntityConfig;

import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.GiaConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.NgayConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.SizeConfigDetail;
import com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail.TrongluongConfigDetail;

import lombok.Data;

@Data
public class MatHangConfig {
    private NgayConfigDetail thoigiannhaphang;
    private GiaConfigDetail gia;
    private TrongluongConfigDetail trongLuong;
    private SizeConfigDetail size;

    public MatHangConfig() {
    }

    public MatHangConfig
        (NgayConfigDetail thoigiannhaphang, GiaConfigDetail gia, TrongluongConfigDetail trongLuong, SizeConfigDetail size) 
            {
        this.thoigiannhaphang = thoigiannhaphang;
        this.gia = gia;
        this.trongLuong = trongLuong;
        this.size = size;
    }


}

package com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail;

import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class TrongluongConfigDetail {
    private Double min;
    private Double max;
    public TrongluongConfigDetail() {
    }
    public TrongluongConfigDetail(Double min, Double max) {
        this.min = min;
        this.max = max;
    }

    public Double getGiaTri(){
        return Faker_Util.getTrongLuong(min, max);
    }
}

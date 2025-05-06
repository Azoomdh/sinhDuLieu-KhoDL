package com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail;

import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class GiaConfigDetail {
    private Long min;
    private Long max;

    public Long getGiaTri(){
        return Faker_Util.getPrice(min, max);
    }

    public Long getGiaTri(Long giatri){
        return giatri;
    }

    public GiaConfigDetail(Long min, Long max) {
        this.min = min;
        this.max = max;
    }

    
}

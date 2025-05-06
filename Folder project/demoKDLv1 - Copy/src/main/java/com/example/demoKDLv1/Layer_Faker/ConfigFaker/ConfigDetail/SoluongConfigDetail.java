package com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail;

import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class SoluongConfigDetail {
    private Integer min;
    private Integer max;

    public Integer getGiaTri(){
        return Faker_Util.getSoluong(this.min, this.max);
    }

    public Integer getGiaTri(Integer n){
        return n;
    }


    public SoluongConfigDetail(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    
}

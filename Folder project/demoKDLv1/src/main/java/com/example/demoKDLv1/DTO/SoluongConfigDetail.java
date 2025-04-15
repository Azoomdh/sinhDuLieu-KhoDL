package com.example.demoKDLv1.DTO;

import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class SoluongConfigDetail {
    private Integer min;
    private Integer max;
    private Integer giaTri;


    public Integer getGiaTri(){
        this.giaTri= Faker_Util.getSoluong(this.min, this.max);
        return this.giaTri;
    }


    public SoluongConfigDetail(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    
}

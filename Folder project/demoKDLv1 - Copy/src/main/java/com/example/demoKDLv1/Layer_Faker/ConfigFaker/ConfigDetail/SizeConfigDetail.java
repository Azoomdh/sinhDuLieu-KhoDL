package com.example.demoKDLv1.Layer_Faker.ConfigFaker.ConfigDetail;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.demoKDLv1.ZZZ_Util.Faker_Util;

import lombok.Data;

@Data
public class SizeConfigDetail {
    private ArrayList<String> listSize  = new ArrayList<>( Arrays.asList("XXS", "XS", "S", "M", "L", "XL", "XXL"));

    public SizeConfigDetail(ArrayList<String> listSize) {
        this.listSize = listSize;
    };

    public String getGiaTri(){
        return Faker_Util.getSize(this.listSize);
    }
}

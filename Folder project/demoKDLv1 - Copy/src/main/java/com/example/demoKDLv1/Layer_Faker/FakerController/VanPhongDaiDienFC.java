package com.example.demoKDLv1.Layer_Faker.FakerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoKDLv1.Layer_Faker.FakerService.VanPhongDaiDienFS;

import ch.qos.logback.core.model.Model;


// @Transactional
@Controller
public class VanPhongDaiDienFC {

    @Autowired
    VanPhongDaiDienFS vpdd_FS;

    @GetMapping("/Faker/CreateVpdd")
    public String getCreateVpddView(Model model){
        
        return "/Faker/CreateVpdd";
    }

    @PostMapping("/Faker/CreateVpdd/SendForm")
    public String postAtCreateVpddView
        (
            Model model,
            @RequestParam("soLuong") Integer soLuong1
        )
        {
            this.vpdd_FS.createVpdd(soLuong1);
            return "redirect:/Faker";
        }
}

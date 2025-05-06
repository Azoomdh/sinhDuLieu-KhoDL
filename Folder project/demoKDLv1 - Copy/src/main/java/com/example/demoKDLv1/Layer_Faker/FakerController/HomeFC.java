package com.example.demoKDLv1.Layer_Faker.FakerController;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// @Transactional
@Controller
public class HomeFC {

    @GetMapping("/Faker")
    public String getFakerHomeView(Model model){
        return "/Faker/HomeView";
    }
}

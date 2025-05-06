package com.example.demoKDLv1.Layer_Faker.FakerController;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang;
import com.example.demoKDLv1.Layer_Entity.KhachHang.KhachHang_Service;
import com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien.KhachHangBuuDien;
import com.example.demoKDLv1.Layer_Entity.KhachHangDuLich.KhachHangDuLich;
import com.example.demoKDLv1.Layer_Faker.FakerService.KhachHangBuuDienFS;
import com.example.demoKDLv1.Layer_Faker.FakerService.KhachHangDuLichFS;
import com.example.demoKDLv1.Layer_Faker.FakerService.KhachHangFS;

@Controller
public class KhdlKhbdFC {

    @Autowired
    KhachHang_Service kh_Service;

    @Autowired
    KhachHangFS kh_FS;

    @Autowired
    KhachHangDuLichFS khdl_FS;

    @Autowired
    KhachHangBuuDienFS khbd_FS;
    
    @GetMapping("/Faker/CreateKhdlKhbd")
    public String getCreateKhdlKhbdView(Model model){
        return "/Faker/CreateKhdlKhbd";
    }

    @Transactional
    @PostMapping("/Faker/CreateKhdlKhbd/SendForm")
    public String postAtCreateKhdlKhbdView
        (
            Model model,
            @RequestParam("soLuong") Integer soLuong1
        )

        {
            List<KhachHang> listKh= this.kh_Service.getRandomKhachhang(soLuong1);

            kh_Service.updateKhachHang(listKh);

            for(KhachHang kh1 : listKh){
                Integer chooseNumber = new Random().nextInt(0, 2);
                
                KhachHangBuuDien khbd= null;
                KhachHangDuLich khdl= null;
                if(chooseNumber== 0){
                    khbd= this.khbd_FS.createKhbd(kh1);
                }

                else{
                    khdl = this.khdl_FS.createKhdl(kh1);
                }
            }

            return "redirect:/Faker/CreateKhdlKhbd";
        }
}

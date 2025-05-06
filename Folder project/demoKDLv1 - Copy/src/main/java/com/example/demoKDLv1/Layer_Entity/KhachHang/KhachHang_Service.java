package com.example.demoKDLv1.Layer_Entity.KhachHang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoKDLv1.ZZZ_Util.HasResultWrapper;


@Transactional
@Service
public class KhachHang_Service implements HasResultWrapper<KhachHang> {
    @Autowired
    private KhachHang_Repo kh_Repo;

    @Autowired
    private KhachHang_RepoEMJ kh_RepoEMJ;

    public KhachHang getKhachhangById(Long id){
        Optional<KhachHang> optionalKhachhang1= this.kh_Repo.findById(id);

        if(optionalKhachhang1.isPresent()== false){
            return null;
        }

        return this.resultWrapper( optionalKhachhang1.get() );
    }

    public KhachHang updateKhachhangById(Long id, KhachHang kh2){
        KhachHang kh1= this.getKhachhangById(id);

        if(kh1== null){
            return null;
        }

        kh1.updateNotId(kh2);

        kh1= this.kh_Repo.saveAndFlush(kh1);

        return this.resultWrapper(kh1);
    }

    public List<KhachHang> updateKhachHang(List<KhachHang> listKh){
        List<KhachHang> listKh2= new ArrayList<>();
        for(KhachHang kh1 : listKh){
            KhachHang kh2 = this.updateKhachhangById(kh1.getMaKH(), kh1);

            listKh2.add(kh2);
        }

        return this.resultWrapper( listKh2 );
    }

    public KhachHang createKhachhang(KhachHang kh2){
        kh2.setMaKH(null);

        kh2= this.kh_Repo.saveAndFlush(kh2);

        return this.resultWrapper(kh2);
    }

    public List<KhachHang> createKhachHang(List<KhachHang> listKh1){
        for(KhachHang kh1 : listKh1){
            kh1.setMaKH(null);
        }

        listKh1 = this.kh_Repo.saveAllAndFlush(listKh1);

        return this.resultWrapper(listKh1);
    }

    public Boolean deleteKhachhangById(Long id){
        
        KhachHang kh1= this.getKhachhangById(id);

        if(kh1== null){
            return false;
        }

        this.kh_Repo.delete(kh1);

        return true;
    }

    public Boolean deleteKhachhang(List<KhachHang> listKh){
        for(KhachHang kh1 : listKh){
            this.deleteKhachhangById(kh1.getMaKH());
        }

        return true;
    }

    // 🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹

    public Page<KhachHang> getListKhachhang(Integer sttPage, Integer sizePage){
        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return this.kh_Repo.findAll(pageable1);
    }
    // 🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸

    public List<KhachHang> getRandomKhachhang(Integer soLuong){
        List<KhachHang> listKhachhang= this.kh_RepoEMJ.getRandomKhachHang(soLuong);

        return this.resultWrapper(listKhachhang);
    }

    @Override
    public KhachHang resultWrapper(KhachHang kh1) {
        KhachHang kh2Refer = this.kh_Repo.getReferenceById(kh1.getMaKH());
        
        return kh2Refer;
    }

    @Override
    public List<KhachHang> resultWrapper(List<KhachHang> listKh1) {
        List<KhachHang> listKh2Refer = new ArrayList<>();

        for(KhachHang kh1 : listKh1){
            KhachHang kh2Refer = this.resultWrapper(kh1);

            listKh2Refer.add(kh2Refer);
        }

        return listKh2Refer;
    }


    
}

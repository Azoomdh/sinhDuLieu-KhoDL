package com.example.demoKDLv1.Layer_Entity.KhachHangBuuDien;

import java.util.ArrayList;
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
public class KhachHangBuuDien_Service implements HasResultWrapper<KhachHangBuuDien> {
    @Autowired
    KhachHangBuuDien_Repo khbd_Repo;

    @Autowired
    KhachHangBuuDien_RepoEMJ khbd_RepoEMJ;
    
    public KhachHangBuuDien getKhbdById(Long id){
        Optional<KhachHangBuuDien> optionalKhbd1= this.khbd_Repo.findById(id);

        if(optionalKhbd1.isPresent()==false){
            return null;
        }

        return this.resultWrapper( optionalKhbd1.get() );
    }

    public KhachHangBuuDien updateKhbdById(Long id, KhachHangBuuDien khbd2){
        KhachHangBuuDien khbd1= this.getKhbdById(id);

        if(khbd1== null){
            return null;
        }

        khbd1.updateNotId(khbd2);

        khbd1= this.khbd_Repo.saveAndFlush(khbd1);

        return this.resultWrapper(khbd1);
    }

    public KhachHangBuuDien createKhbd(KhachHangBuuDien khbd2){
        // do khbd kế thừa từ khachHang nên không được set null
        // khbd2.setMaKH(khbd2.getMaKH());
        
        khbd2= this.khbd_Repo.saveAndFlush(khbd2);

        return this.resultWrapper(khbd2);
    }

    public Boolean deleteKhbdById(Long id){
        KhachHangBuuDien khbd1= this.getKhbdById(id);

        if(khbd1== null){
            return false;
        }

        this.khbd_Repo.delete(khbd1);

        return true;
    }
    // 🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹

    public Page<KhachHangBuuDien> getListKhbd(Integer sttPage, Integer sizePage){
        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return this.khbd_Repo.findAll(pageable1);
    }
    // 🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸

    @Override
    public KhachHangBuuDien resultWrapper(KhachHangBuuDien khbd1) {
        KhachHangBuuDien kh2Refer = this.khbd_Repo.getReferenceById(khbd1.getMaKH());
        return kh2Refer;
    }

    @Override
    public List<KhachHangBuuDien> resultWrapper(List<KhachHangBuuDien> listKhbd1) {
        List<KhachHangBuuDien> listKhbd2Refer = new ArrayList<>();

        for(KhachHangBuuDien khbd1 : listKhbd1){
            KhachHangBuuDien khbd2Refer = this.resultWrapper(khbd1);

            listKhbd2Refer.add(khbd2Refer);
        }
        return listKhbd2Refer;
    }
    

    
}

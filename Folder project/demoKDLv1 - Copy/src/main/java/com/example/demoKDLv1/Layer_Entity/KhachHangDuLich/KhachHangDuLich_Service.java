package com.example.demoKDLv1.Layer_Entity.KhachHangDuLich;

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
public class KhachHangDuLich_Service implements HasResultWrapper<KhachHangDuLich> {
    @Autowired
    KhachHangDuLich_Repo khdl_Repo;

    @Autowired
    KhachHangDuLich_RepoEMJ khdl_RepoEMJ;

    public KhachHangDuLich getKhdlById(Long id){
        Optional<KhachHangDuLich> optionalKhdl1= this.khdl_Repo.findById(id);

        if(optionalKhdl1.isPresent()== false){
            return null;
        }

        return this.resultWrapper( optionalKhdl1.get() );
    }

    public KhachHangDuLich updateKhdlById(Long id, KhachHangDuLich khdl2){

        KhachHangDuLich khdl1= this.getKhdlById(id);

        if(khdl1== null){
            return null;
        }

        khdl1.updateNotId(khdl2);

        khdl1= this.khdl_Repo.saveAndFlush(khdl1);

        return this.resultWrapper( khdl1 );
    }

    public KhachHangDuLich createKhdl(KhachHangDuLich khdl2){
        // khdl kế thừa từ KhachHang, KhachHang != null 
        // khdl2.setMaKH(khdl2.getMaKH());

        khdl2= this.khdl_Repo.saveAndFlush(khdl2);

        return this.resultWrapper( khdl2 );
    }

    public Boolean deleteKhdlById(Long id){
        KhachHangDuLich khdl1= this.getKhdlById(id);

        if(khdl1== null){
            return false;
        }

        this.khdl_Repo.delete(khdl1);

        return true;
    }

    // 🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹

    public Page<KhachHangDuLich> getListKhdl(Integer sttPage, Integer sizePage){

        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return this.khdl_Repo.findAll(pageable1);
    }
    // 🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸

    @Override
    public KhachHangDuLich resultWrapper(KhachHangDuLich khdl1) {
        
        KhachHangDuLich khdl2Refer= this.khdl_Repo.getReferenceById(khdl1.getMaKH());

        return khdl2Refer;
    }

    @Override
    public List<KhachHangDuLich> resultWrapper(List<KhachHangDuLich> listKhdl1) {

        List<KhachHangDuLich> listKhdl2Refer = new ArrayList<>();

        for(KhachHangDuLich khdl1 : listKhdl1){
            KhachHangDuLich khdl2Refer= this.resultWrapper(khdl1);

            listKhdl2Refer.add(khdl2Refer);
        }

        return listKhdl2Refer;
    }
    
    
}

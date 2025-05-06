package com.example.demoKDLv1.Layer_Entity.VanPhongDaiDien;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class VanPhongDaiDien_Service {
    @Autowired
    VanPhongDaiDien_Repo vpdd_Repo;

    @Autowired
    VanPhongDaiDien_RepoEMJ vpdd_RepoEMJ;

    public VanPhongDaiDien getVpddById(Long id){
        Optional<VanPhongDaiDien> optionalVpdd1= this.vpdd_Repo.findById(id);

        if(optionalVpdd1.isPresent()== false){
            return null;
        }

        return optionalVpdd1.get();
    }

    public VanPhongDaiDien updateVpddById(Long id, VanPhongDaiDien vpdd2){
        
        VanPhongDaiDien vpdd1= this.getVpddById(id);

        if(vpdd1== null){
            return null;
        }

        vpdd1.updateNotId(vpdd2);

        vpdd1= this.vpdd_Repo.saveAndFlush(vpdd1);

        return vpdd1;
    }

    public VanPhongDaiDien createVpdd(VanPhongDaiDien vpdd2){
        vpdd2.setMaTP(null);

        vpdd2= this.vpdd_Repo.saveAndFlush(vpdd2);

        return vpdd2;
    }

    public Boolean deleteVpddById(Long maTp){
        VanPhongDaiDien vpdd1= this.getVpddById(maTp);

        if(vpdd1== null){
            return false;
        }

        this.vpdd_Repo.delete(vpdd1);

        return true;
    }

    // 🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹

    public Page<VanPhongDaiDien> getListVpdd(Integer sttPage, Integer sizePage){

        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return this.vpdd_Repo.findAll(pageable1);
    }

    public void saveAllAndFlushVpdd(List<VanPhongDaiDien> listVpdd){
        this.vpdd_Repo.saveAllAndFlush(listVpdd);
    }
}

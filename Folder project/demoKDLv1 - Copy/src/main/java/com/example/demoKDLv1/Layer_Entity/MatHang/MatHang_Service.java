package com.example.demoKDLv1.Layer_Entity.MatHang;

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
public class MatHang_Service {

    @Autowired
    MatHang_Repo mh_Repo;

    @Autowired
    MatHang_RepoEMJ mh_RepoEMJ;

    public MatHang getMathangById(Long id){
        Optional<MatHang> optionalMathang1= this.mh_Repo.findById(id);

        if(optionalMathang1.isPresent()== false){
            return null;
        }

        return optionalMathang1.get();
    }

    public MatHang updateMathangById(Long id, MatHang mh2){

        MatHang mh1= this.getMathangById(id);

        if(mh1== null){
            return null;
        }

        mh1.updateNotId(mh2);

        mh1= this.mh_Repo.saveAndFlush(mh1);

        return mh1;
    }

    public MatHang createMathang(MatHang mh2){
        mh2.setMaMH(null);

        mh2= this.mh_Repo.saveAndFlush(mh2);

        return mh2;
    }

    public Boolean deleteMathangById(Long id){
        MatHang mh1= this.getMathangById(id);

        if(mh1== null){
            return false;
        }

        this.mh_Repo.delete(mh1);

        return true;
    }

    // 🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹

    public Page<MatHang> getListMathang(Integer sttPage, Integer sizePage){

        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return this.mh_Repo.findAll(pageable1);
    }

    public List<MatHang> getRandomMathang(Integer soLuong){
        List<MatHang> listMh= this.mh_RepoEMJ.getRandomMatHang(soLuong);

        return listMh;
    }

    public List<MatHang> createAllMathang(List<MatHang> listMathang){
        return this.mh_Repo.saveAllAndFlush(listMathang);
    }
}

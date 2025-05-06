package com.example.demoKDLv1.Layer_Entity.MatHangDuocLuuTru;

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
public class MatHangDuocLuuTru_Service {
    @Autowired
    MatHangDuocLuuTru_Repo mhdlt_Repo;

    @Autowired
    MatHangDuocLuuTru_RepoEMJ mhdlt_repoEMJ;

    public MatHangDuocLuuTru getMhdltById(Long mach, Long mamh){
        MatHangDuocLuuTru_Key mhdltKey= new MatHangDuocLuuTru_Key(mach, mamh);

        Optional<MatHangDuocLuuTru> optionalMhdlt1= this.mhdlt_Repo.findById(mhdltKey);

        if(optionalMhdlt1.isPresent()== false){
            return null;
        }

        return optionalMhdlt1.get();
    }

    public MatHangDuocLuuTru updateMhdltById(Long mach, Long mamh, MatHangDuocLuuTru mhdlt2){
        MatHangDuocLuuTru mhdlt1= this.getMhdltById(mach, mamh);

        if(mhdlt1== null){
            return null;
        }

        mhdlt1.updateNotId(mhdlt2);

        mhdlt1= this.mhdlt_Repo.saveAndFlush(mhdlt1);

        return mhdlt1;
        
    }

    public MatHangDuocLuuTru createMhdlt(MatHangDuocLuuTru mhdlt2){
        // Không set khóa ngoại về null

        mhdlt2= this.mhdlt_Repo.saveAndFlush(mhdlt2);

        return mhdlt2;
    }

    public Boolean deleteMhdltById(Long mach, Long mamh){
        MatHangDuocLuuTru mhdlt1= this.getMhdltById(mach, mamh);

        if(mhdlt1== null){
            return false;
        }

        this.mhdlt_Repo.delete(mhdlt1);

        return true;
    }

    // 🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹🔹

    public Page<MatHangDuocLuuTru> getListMhdlt(Integer sttPage, Integer sizePage){

        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return this.mhdlt_Repo.findAll(pageable1);
    }
    // 🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸🔸
    
    public List<MatHangDuocLuuTru> createAllMhdlt(List<MatHangDuocLuuTru> listMhdlt){
        listMhdlt= this.mhdlt_Repo.saveAllAndFlush(listMhdlt);

        return listMhdlt;
    }
}

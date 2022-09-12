package com.assessment.first_case.repo;

import com.assessment.first_case.model.Urun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UrunRepo extends JpaRepository<Urun, Long> {



    //Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız
    @Query ("FROM Urun  WHERE sonKulTar < CURRENT_DATE")
    List<Urun> findAllValid();

    //Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
    @Query ("FROM Urun  WHERE sonKulTar > CURRENT_DATE or sonKulTar is null ")
    List<Urun> findAllValidWithNull();
}

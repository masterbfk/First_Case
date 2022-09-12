package com.assessment.first_case.repo;

import com.assessment.first_case.model.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface UrunYorumRepo extends JpaRepository<UrunYorum, Long> {
     @Query("From UrunYorum where urunId=:urunId")
     List<UrunYorum> getByUrunId(long urunId);

     @Query(value = "From UrunYorum where urunId=?1 and yorumTarihi BETWEEN ?2 AND ?3")
     List<UrunYorum> findAllByYorumTarihiWithUrunId(Long id, LocalDateTime endDate, LocalDateTime startDate);

     List<UrunYorum> findAllByKullaniciId(long id);

     @Query(value = "From UrunYorum where kullaniciId=?1 and yorumTarihi BETWEEN ?2 AND ?3")
     List<UrunYorum> findAllByKullaniciIdAndDate(long id,LocalDateTime startDate,LocalDateTime endDate);
}

package com.assessment.first_case.service;

import com.assessment.first_case.dtos.GetIdAndDate;
import com.assessment.first_case.model.Urun;
import com.assessment.first_case.model.UrunYorum;
import com.assessment.first_case.repo.UrunRepo;
import com.assessment.first_case.repo.UrunYorumRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UrunService {

    private final UrunRepo urunRepo;
    private final UrunYorumRepo urunYorumRepo;

    public UrunService(UrunRepo urunRepo, UrunYorumRepo urunYorumRepo) {
        this.urunRepo = urunRepo;
        this.urunYorumRepo = urunYorumRepo;
    }

    public Urun addUrun(String adi)
    {
      return urunRepo.save(new Urun(adi, 100L,LocalDateTime.now()));
    }

    //Bir ürüne ait yorumları listeleyen bir metot yazınız.
    public List<UrunYorum> getAllYorumByUrunId(long urunId)
    {
        return urunYorumRepo.getByUrunId(urunId);
    }
    //Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
    public List<UrunYorum> getAllYorumByTarih(GetIdAndDate model)
    {
        return urunYorumRepo.findAllByYorumTarihiWithUrunId(model.getId(),model.getEndDate(),model.getStartDate());
    }
    //Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
    public List<UrunYorum> getAllYorumByKullanici(Long id)
    {
        return urunYorumRepo.findAllByKullaniciId(id);
    }
    //Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
    public List<UrunYorum> getAllYorumByKullaniciAndTarih(GetIdAndDate model)
    {
        return urunYorumRepo.findAllByKullaniciIdAndDate(model.getId(),model.getStartDate(),model.getEndDate());
    }

    public List<Urun> getSonKulTarGecmis()
    {
        return urunRepo.findAllValid();
    }

    public List<Urun> getSonKulTarGecmemisWithNull()
    {
        return urunRepo.findAllValidWithNull();
    }

}

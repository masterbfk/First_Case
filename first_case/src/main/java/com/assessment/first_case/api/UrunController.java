package com.assessment.first_case.api;

import com.assessment.first_case.dtos.GetIdAndDate;
import com.assessment.first_case.model.Urun;
import com.assessment.first_case.model.UrunYorum;
import com.assessment.first_case.service.UrunService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/urun")
public class UrunController {
    private final UrunService urunService;

    public UrunController(UrunService urunService) {
        this.urunService = urunService;
    }

    @GetMapping("/addurun/{adi}")
    public ResponseEntity<Urun> getAllYorumByUrun(@PathVariable("adi") String adi){
        return new ResponseEntity<>(urunService.addUrun(adi), HttpStatus.CREATED);
    }
    //Bir ürüne ait yorumları listeleyen bir metot yazınız.
    @GetMapping("/yorumlar/{id}")
    public ResponseEntity<List<UrunYorum>> getAllYorumByUrun(@PathVariable("id") Long id){
        List<UrunYorum> yorumlar = urunService.getAllYorumByUrunId(id);
        return new ResponseEntity<>(yorumlar, HttpStatus.OK);
    }
    //Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
    @PostMapping ("/yorumlar/GetIdAndDates")
    public ResponseEntity<List<UrunYorum>> getIdAndDate(@RequestBody GetIdAndDate model ){
        List<UrunYorum> yorumlar = urunService.getAllYorumByTarih(model);
        return new ResponseEntity<>(yorumlar, HttpStatus.OK);
    }
    //Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
    @GetMapping ("/kullaniciYorumlari/{id}")
    public ResponseEntity<List<UrunYorum>> getIdAndUser(@PathVariable("id") Long id ){
        List<UrunYorum> yorumlar = urunService.getAllYorumByKullanici(id);
        return new ResponseEntity<>(yorumlar, HttpStatus.OK);
    }
    //Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
    @PostMapping ("/kullaniciYorumlari/GetIdAndDates")
    public ResponseEntity<List<UrunYorum>> getIdAndDateUser(@RequestBody GetIdAndDate model ){
        List<UrunYorum> yorumlar = urunService.getAllYorumByKullaniciAndTarih(model);
        return new ResponseEntity<>(yorumlar, HttpStatus.OK);
    }
    //Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.
    @GetMapping ("/urun/sonKulTarGecmis")
    public ResponseEntity<List<Urun>> getGecmis(){
        List<Urun> urunler = urunService.getSonKulTarGecmis();
        return new ResponseEntity<>(urunler, HttpStatus.OK);
    }
    //Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
    @GetMapping ("/urun/sonKulTarGecmemis")
    public ResponseEntity<List<Urun>> getGecmemis(){
        List<Urun> urunler = urunService.getSonKulTarGecmemisWithNull();
        return new ResponseEntity<>(urunler, HttpStatus.OK);
    }
}

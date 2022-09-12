package com.assessment.first_case.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String adi;
    private Long fiyat;
    @Nullable
    private LocalDateTime sonKulTar;

    public Urun() {
    }

    public Urun(String adi, Long fiyat, @Nullable LocalDateTime sonKulTar) {
        this.adi = adi;
        this.fiyat = fiyat;
        this.sonKulTar = sonKulTar;
    }
}

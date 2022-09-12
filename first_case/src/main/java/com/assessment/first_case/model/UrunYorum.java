package com.assessment.first_case.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UrunYorum {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    @Column(length = 500)
    private String yorum;
    private Long urunId;
    private Long kullaniciId;
    private LocalDateTime yorumTarihi;
}

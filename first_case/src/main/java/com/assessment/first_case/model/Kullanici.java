package com.assessment.first_case.model;

import javax.persistence.*;


@Entity
public class Kullanici {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    @Column(length = 50)
    private String adi;
    @Column(length = 50)
    private String soyadi;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String telefon;

    public Kullanici() {
    }

    public Kullanici(String adi, String soyadi, String email, String telefon) {
        this.adi = adi;
        this.soyadi = soyadi;
        this.email = email;
        this.telefon = telefon;
    }
}

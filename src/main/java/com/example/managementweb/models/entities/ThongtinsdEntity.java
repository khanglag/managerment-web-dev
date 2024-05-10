package com.example.managementweb.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thongtinsd")
public class ThongtinsdEntity {
    @Id
    @Column(name = "MaTT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaTV", nullable = false)
    private ThanhvienEntity maTV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTB")
    private ThietbiEntity maTB;

    @Column(name = "tgvao")
    private LocalDate tgvao;

    @Column(name = "tgmuon")
    private LocalDate tgmuon;

    @Column(name = "tgtra")
    private LocalDate tgtra;

    @Column(name = "tgdatcho")
    private LocalDate tgdatcho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ThanhvienEntity getMaTV() {
        return maTV;
    }

    public void setMaTV(ThanhvienEntity maTV) {
        this.maTV = maTV;
    }

    public ThietbiEntity getMaTB() {
        return maTB;
    }

    public void setMaTB(ThietbiEntity maTB) {
        this.maTB = maTB;
    }

    public LocalDate getTgvao() {
        return tgvao;
    }

    public void setTgvao(LocalDate tgvao) {
        this.tgvao = tgvao;
    }

    public LocalDate getTgmuon() {
        return tgmuon;
    }

    public void setTgmuon(LocalDate tgmuon) {
        this.tgmuon = tgmuon;
    }

    public LocalDate getTgtra() {
        return tgtra;
    }

    public void setTgtra(LocalDate tgtra) {
        this.tgtra = tgtra;
    }

    public LocalDate getTgdatcho() {
        return tgdatcho;
    }

    public void setTgdatcho(LocalDate tgdatcho) {
        this.tgdatcho = tgdatcho;
    }
}
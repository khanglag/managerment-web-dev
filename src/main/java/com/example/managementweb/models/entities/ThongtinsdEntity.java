package com.example.managementweb.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

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
    private Instant tgvao;

    @Column(name = "tgmuon")
    private Instant tgmuon;

    @Column(name = "tgtra")
    private Instant tgtra;

    @Column(name = "tgdatcho")
    private Instant tgdatcho;

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

    public Instant getTgvao() {
        return tgvao;
    }

    public void setTgvao(Instant tgvao) {
        this.tgvao = tgvao;
    }

    public Instant getTgmuon() {
        return tgmuon;
    }

    public void setTgmuon(Instant tgmuon) {
        this.tgmuon = tgmuon;
    }

    public Instant getTgtra() {
        return tgtra;
    }

    public void setTgtra(Instant tgtra) {
        this.tgtra = tgtra;
    }

    public Instant getTgdatcho() {
        return tgdatcho;
    }

    public void setTgdatcho(Instant tgdatcho) {
        this.tgdatcho = tgdatcho;
    }

}
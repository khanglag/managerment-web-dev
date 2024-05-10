package com.example.managementweb.models.dtos.Thongtinsd;

import java.time.LocalDate;

public class ThongtinsdReponsDto {
    private Integer id;
    private Integer maTVId;
    private Integer maTBId;
    private LocalDate tgvao;
    private LocalDate tgmuon;
    private LocalDate tgtra;
    private LocalDate tgdatcho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaTVId() {
        return maTVId;
    }

    public void setMaTVId(Integer maTVId) {
        this.maTVId = maTVId;
    }

    public Integer getMaTBId() {
        return maTBId;
    }

    public void setMaTBId(Integer maTBId) {
        this.maTBId = maTBId;
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

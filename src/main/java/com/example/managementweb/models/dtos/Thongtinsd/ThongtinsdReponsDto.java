package com.example.managementweb.models.dtos.Thongtinsd;

import java.time.LocalDateTime;

public class ThongtinsdReponsDto {
    private Integer id;
    private Integer maTVId;
    private Integer maTBId;
    private LocalDateTime tgvao;
    private LocalDateTime tgmuon;
    private LocalDateTime tgtra;
    private LocalDateTime tgdatcho;

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

    public LocalDateTime getTgvao() {
        return tgvao;
    }

    public void setTgvao(LocalDateTime tgvao) {
        this.tgvao = tgvao;
    }

    public LocalDateTime getTgmuon() {
        return tgmuon;
    }

    public void setTgmuon(LocalDateTime tgmuon) {
        this.tgmuon = tgmuon;
    }

    public LocalDateTime getTgtra() {
        return tgtra;
    }

    public void setTgtra(LocalDateTime tgtra) {
        this.tgtra = tgtra;
    }

    public LocalDateTime getTgdatcho() {
        return tgdatcho;
    }

    public void setTgdatcho(LocalDateTime tgdatcho) {
        this.tgdatcho = tgdatcho;
    }
}

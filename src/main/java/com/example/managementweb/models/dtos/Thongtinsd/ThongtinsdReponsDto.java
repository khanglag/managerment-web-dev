package com.example.managementweb.models.dtos.ThongTinSD;

import java.time.LocalDateTime;

public class ThongtinsdReponsDto {
    private int id;
    private int maTVId;
    private String maTBId;
    private LocalDateTime tgvao;
    private LocalDateTime tgmuon;
    private LocalDateTime tgtra;
    private LocalDateTime tgdatcho;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaTVId() {
        return maTVId;
    }

    public void setMaTVId(int maTVId) {
        this.maTVId = maTVId;
    }

    public String getMaTBId() {
        return maTBId;
    }

    public void setMaTBId(String maTBId) {
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

    @Override
    public String toString() {
        return "ThongtinsdReponsDto{" +
                "id=" + id +
                ", maTVId=" + maTVId +
                ", maTBId='" + maTBId + '\'' +
                ", tgvao=" + tgvao +
                ", tgmuon=" + tgmuon +
                ", tgtra=" + tgtra +
                ", tgdatcho=" + tgdatcho +
                '}';
    }
}

package com.example.managementweb.models.dtos.Thongtinsd;
import java.time.LocalDateTime;

public class ThongtinsudungdangmuonDto {
    @Override
    public String toString() {
        return "Thongtinsudungdangmuon{" +
                "id=" + id +
                ", maTVId=" + maTVId +
                ", maTBId=" + maTBId +
                ", maTBName='" + maTBName + '\'' +
                ", tgvao=" + tgvao +
                ", tgmuon=" + tgmuon +
                ", tgtra=" + tgtra +
                ", tgdatcho=" + tgdatcho +
                '}';
    }

    public ThongtinsudungdangmuonDto(Integer id, Integer maTVId, Integer maTBId, String maTBName, LocalDateTime tgvao,
            LocalDateTime tgmuon, LocalDateTime tgtra, LocalDateTime tgdatcho) {
        this.id = id;
        this.maTVId = maTVId;
        this.maTBId = maTBId;
        this.maTBName = maTBName;
        this.tgvao = tgvao;
        this.tgmuon = tgmuon;
        this.tgtra = tgtra;
        this.tgdatcho = tgdatcho;
    }

    private Integer id;
    private Integer maTVId;
    private Integer maTBId;
    private String maTBName;
    private LocalDateTime tgvao;

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

    public String getMaTBName() {
        return maTBName;
    }

    public void setMaTBName(String maTBName) {
        this.maTBName = maTBName;
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

    private LocalDateTime tgmuon;
    private LocalDateTime tgtra;
    private LocalDateTime tgdatcho;

}

package com.example.managementweb.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "xuly")
public class XulyEntity {
    @Id
    @Column(name = "MaXL", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaTV", nullable = false)
    private ThanhvienEntity maTV;

    @Column(name = "HinhthucXL", length = 250)
    private String hinhthucXL;

    @Column(name = "Sotien")
    private Integer sotien;

    @Column(name = "ngayxl")
    private LocalDate ngayxl;

    @Column(name = "TrangthaiXL")
    private Integer trangthaiXL;

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

    public String getHinhthucXL() {
        return hinhthucXL;
    }

    public void setHinhthucXL(String hinhthucXL) {
        this.hinhthucXL = hinhthucXL;
    }

    public Integer getSotien() {
        return sotien;
    }

    public void setSotien(Integer sotien) {
        this.sotien = sotien;
    }

    public LocalDate getNgayxl() {
        return ngayxl;
    }

    public void setNgayxl(LocalDate ngayxl) {
        this.ngayxl = ngayxl;
    }

    public Integer getTrangthaiXL() {
        return trangthaiXL;
    }

    public void setTrangthaiXL(Integer trangthaiXL) {
        this.trangthaiXL = trangthaiXL;
    }

}
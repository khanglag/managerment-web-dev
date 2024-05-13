package com.example.managementweb.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

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
    private LocalDateTime ngayxl;

    @Column(name = "TrangthaiXL")
    private Integer trangthaiXL;

    public Integer getmaTV() {
        return maTV != null ? maTV.getId() : null; 
    }

    
    

    @Override
    public String toString() {
        return "{" +
                " MaXL='" + getId() + "'" +
                ", MaTV='" + getmaTV() + "'" +
                ", HinhThucXL='" + getHinhthucXL() + "'" +
                ", SoTien='" + getSotien() + "'" +
                ", NgayXL='" + getNgayxl() + "'" +
                ", TrangThaiXL='" + getTrangthaiXL() + "'" +
                "}";
    }

}
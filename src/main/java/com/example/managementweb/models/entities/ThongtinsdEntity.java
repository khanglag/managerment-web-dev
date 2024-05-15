package com.example.managementweb.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thongtinsd")
public class ThongtinsdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaTT", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MaTV", nullable = false)
    private ThanhvienEntity maTV;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MaTB")
    private ThietbiEntity maTB;

    @Column(name = "tgvao")
    private LocalDateTime tgvao;

    @Column(name = "tgmuon")
    private LocalDateTime tgmuon;

    @Column(name = "tgtra")
    private LocalDateTime tgtra;

    @Column(name = "tgdatcho")
    private LocalDateTime tgdatcho;

    public Integer getMaTV() {
        return maTV != null ? maTV.getId() : null;
    }

    public Integer getMaTB() {
        return maTB != null ? maTB.getId() : null;
    }

    public boolean daDatCho() {
        return tgdatcho == null;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", maTV='" + getMaTV() + "'" +
                ", maTB='" + getMaTB() + "'" +
                ", tgvao='" + getTgvao() + "'" +
                ", tgmuon='" + getTgmuon() + "'" +
                ", tgtra='" + getTgtra() + "'" +
                ", tgdatcho='" + getTgdatcho() + "'" +
                "}";
    }
}
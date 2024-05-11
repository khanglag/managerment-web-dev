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

    public Integer getMaTV() {
        return maTV != null ? maTV.getId() : null;
    }

    public Integer getMaTB() {
        return maTB != null ? maTB.getId() : null;
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
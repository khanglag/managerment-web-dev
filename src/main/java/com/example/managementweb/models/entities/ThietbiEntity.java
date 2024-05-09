package com.example.managementweb.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "thietbi")
public class ThietbiEntity {
    @Id
    @Column(name = "MaTB", nullable = false)
    private Integer id;

    @Column(name = "TenTB", nullable = false, length = 100)
    private String tenTB;

    @Lob
    @Column(name = "MotaTB")
    private String motaTB;

    @OneToMany(mappedBy = "maTB")
    private Set<ThongtinsdEntity> thongtinsds = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenTB() {
        return tenTB;
    }

    public void setTenTB(String tenTB) {
        this.tenTB = tenTB;
    }

    public String getMotaTB() {
        return motaTB;
    }

    public void setMotaTB(String motaTB) {
        this.motaTB = motaTB;
    }

    public Set<ThongtinsdEntity> getThongtinsds() {
        return thongtinsds;
    }

    public void setThongtinsds(Set<ThongtinsdEntity> thongtinsds) {
        this.thongtinsds = thongtinsds;
    }

}
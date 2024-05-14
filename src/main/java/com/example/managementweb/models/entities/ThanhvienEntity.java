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
@Table(name = "thanhvien")
public class ThanhvienEntity {
    @Id
    @Column(name = "MaTV", nullable = false)
    private Integer id;

    @Column(name = "Hoten", nullable = false, length = 100)
    private String hoten;

    @Column(name = "Khoa", length = 100)
    private String khoa;

    @Column(name = "Nganh", length = 100)
    private String nganh;

    @Column(name = "SDT", length = 15)
    private String sdt;

    @Column(name = "Password", length = 20)
    private String password;

    @Column(name = "Email", length = 250)
    private String email;

    @OneToMany(mappedBy = "maTV")
    private Set<ThongtinsdEntity> thongtinsds = new LinkedHashSet<>();

    @OneToMany(mappedBy = "maTV")
    private Set<XulyEntity> xulies = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public Set<ThongtinsdEntity> getThongtinsds() {
        return thongtinsds;
    }

    public void setThongtinsds(Set<ThongtinsdEntity> thongtinsds) {
        this.thongtinsds = thongtinsds;
    }

    public Set<XulyEntity> getXulies() {
        return xulies;
    }

    public void setXulies(Set<XulyEntity> xulies) {
        this.xulies = xulies;
    }

}
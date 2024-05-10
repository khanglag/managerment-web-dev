package com.example.managementweb.models.dtos.Thanhvien;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThanhvienReponsDto {
    private String id;

    @Override
    public String toString() {
        return "ThanhvienReponsDto{" +
                "id='" + id + '\'' +
                ", hoten='" + hoten + '\'' +
                ", khoa='" + khoa + '\'' +
                ", nganh='" + nganh + '\'' +
                ", sdt='" + sdt + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private String hoten;
    private String khoa;
    private String nganh;
    private String sdt;
    private String password;
    private String email;
}

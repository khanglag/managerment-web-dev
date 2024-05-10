package com.example.managementweb.models.dtos.Thanhvien;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateThanhvienDto implements Serializable {
    @NotBlank(message = "Mã thành viên không được để trống")
    private String id;

    @Override
    public String toString() {
        return "CreateThanhvienDto{" +
                "id='" + id + '\'' +
                ", hoten='" + hoten + '\'' +
                ", khoa='" + khoa + '\'' +
                ", nganh='" + nganh + '\'' +
                ", sdt='" + sdt + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @NotBlank(message = "Họ tên không được để trống")
    private String hoten;

    private String khoa;

    private String nganh;

    @Size(min = 10, max = 15, message = "Số điện thoại phải từ 10 đến 15 ký tự")
    private String sdt;

    @NotBlank(message = "Password không được để trống")
    private String password;

    @NotBlank(message = "Email không được để trống")
    private String email;
}
package com.example.managementweb.models.dtos.Xuly;

import java.io.Serializable;
import java.time.LocalDate;

import org.aspectj.lang.annotation.AdviceName;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateXuLyDto implements Serializable {
    @NotBlank(message = "Mã xử lý không được để trống")
    private String id;
    @NotBlank(message = "Mã thành viên không được để trống")
    private ThanhvienReponsDto maTV;
    private  String hinhthucXL;
    private Integer sotien;
    private LocalDate ngayxl;
    private Integer trangthaiXL;
    
}

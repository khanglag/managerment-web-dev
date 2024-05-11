package com.example.managementweb.models.dtos.Xuly;


import java.time.LocalDate;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;
import com.example.managementweb.models.entities.ThanhvienEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XuLyReponsDtos {
    private Integer id;
    private Integer maTV;
    private String hinhthucXL;
    private Integer sotien;
    private LocalDate ngayxl;
    private Integer trangthaiXL;

} 

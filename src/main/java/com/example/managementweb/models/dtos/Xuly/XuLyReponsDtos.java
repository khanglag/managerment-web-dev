package com.example.managementweb.models.dtos.Xuly;


import java.time.LocalDate;

import com.example.managementweb.models.dtos.Thanhvien.ThanhvienReponsDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class XuLyReponsDtos {
    private String id;
    private ThanhvienReponsDto maTV;
    private String hinhthucXL;
    private Integer sotien;
    private LocalDate ngayxl;
    private Integer trangthaiXL;
} 

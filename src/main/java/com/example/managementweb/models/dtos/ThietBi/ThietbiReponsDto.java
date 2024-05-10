package com.example.managementweb.models.dtos.ThietBi;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThietbiReponsDto {
    private String id;
    private String tenTB;
    private String motaTB;
}

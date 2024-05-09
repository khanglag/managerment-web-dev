// package com.example.managementweb.models.dtos.ThietBi;

// import java.io.Serializable;

// import groovy.transform.builder.Builder;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Pattern;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class ThietbiCreateDto implements Serializable{
//     @NotBlank (message = "Mã thiết bị không được để trống")
//     @Pattern(regexp = "\\d", message = "Mã thiết bị chỉ chứa ký tự số")
//     int MaTB;
//     @NotBlank (message = "Tên thiết bị không được để trống")
//     String TenTB;
//     @NotBlank (message = "Mô tả thiết bị không được để trống")
//     String MoTa;
// }

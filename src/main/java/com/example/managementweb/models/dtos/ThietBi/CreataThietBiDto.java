package com.example.managementweb.models.dtos.ThietBi;


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
public class CreataThietBiDto implements Serializable {
    @NotBlank(message = "Mã thiết bị không được để trống")
    
    private String id;

    @NotBlank(message = "Tên thiết bị không được để trống")
    private String tenTB;

    private String motaTB;

    
}

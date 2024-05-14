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

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}

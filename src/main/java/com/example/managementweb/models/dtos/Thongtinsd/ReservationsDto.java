package com.example.managementweb.models.dtos.Thongtinsd;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservationsDto {
    private Integer id;
    private Integer maTVId;
    private Integer maTBId;
    @NotNull(message = "thời gian đặt trước không để trống")
    @Future(message = "Thời gian đặt phải là ngày của tương lai")
    private LocalDateTime tgdatcho;
}

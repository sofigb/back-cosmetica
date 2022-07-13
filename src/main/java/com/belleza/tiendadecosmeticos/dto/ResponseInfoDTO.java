package com.belleza.tiendadecosmeticos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ResponseInfoDTO {

    private String timestap = LocalDate.now().toString();
    @NonNull
    private String message;

    @NonNull
    private Integer codeStatus;
}

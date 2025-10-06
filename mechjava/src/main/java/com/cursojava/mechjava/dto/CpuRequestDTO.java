package com.cursojava.mechjava.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * DTO para peticiones de cálculo de Fibonacci
 */
public record CpuRequestDTO(
        @NotNull(message = "El valor n es requerido")
        @Min(value = 1, message = "n debe ser mayor o igual a 1")
        @Max(value = 92, message = "n debe ser menor o igual a 92 para evitar overflow")
        Integer n,

        @NotNull(message = "El flag slow es requerido")
        Boolean slow,

        @NotNull(message = "El número de repeticiones es requerido")
        @Min(value = 1, message = "Las repeticiones deben ser mayor o igual a 1")
        @Max(value = 1_000_000, message = "Las repeticiones deben ser menor o igual a 1,000,000")
        Integer repetitions
) {
    public CpuRequestDTO {
        if (n == null) n = 40;
        if (slow == null) slow = true;
        if (repetitions == null) repetitions = 1;
    }
}


package com.cursojava.mechjava.dto;

/**
 * DTO para respuestas del servicio de CPU
 */
public record CpuResponseDTO(
        long result,
        long elapsedMillis,
        boolean slow,
        int repetitions
) {}

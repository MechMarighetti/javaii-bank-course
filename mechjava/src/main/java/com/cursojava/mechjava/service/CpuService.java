package com.cursojava.mechjava.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.cursojava.mechjava.dto.CpuRequestDTO;
import com.cursojava.mechjava.dto.CpuResponseDTO;



/**
 * Servicio de CPU con métodos optimizados y no optimizados
 */
@Slf4j
@Service
public class CpuService {



    public CpuResponseDTO fib(CpuRequestDTO req) {
        long startTime = System.nanoTime();
        long result = 0;

        // Ejecutar el cálculo las veces especificadas
        for (int i = 0; i < req.repetitions(); i++) {
            if (req.slow()) {
                result = fibSlow(req.n());
            } else {
                result = fibFast(req.n());
            }
        }

        long endTime = System.nanoTime();
        long elapsedMillis = (endTime - startTime) / 1_000_000;

        return new CpuResponseDTO(result, elapsedMillis, req.slow(), req.repetitions());
    }

    /**
     * Implementación recursiva ineficiente O(φ^n) - para generar carga de CPU
     */
    private long fibSlow(int n) {
        if (n <= 1) {
            return n;
        }
        return fibSlow(n - 1) + fibSlow(n - 2);
    }

    /**
     * Implementación iterativa optimizada O(n) - para comparar rendimiento
     */
    private long fibFast(int n) {
        if (n <= 1) {
            return n;
        }

        // Calcular iterativamente
        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
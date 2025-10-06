package com.cursojava.mechjava.controller;

import com.cursojava.mechjava.dto.CpuRequestDTO;
import com.cursojava.mechjava.dto.CpuResponseDTO;
import com.cursojava.mechjava.service.CpuService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para demo de CPU con JProfiler
 */
@Slf4j
@RestController
@RequestMapping("/perf/cpu")
@RequiredArgsConstructor
public class CpuController {

    private final CpuService cpuService;

    /**
     * Demo rápida para JProfiler - versión lenta
     */
    @GetMapping("/demo/slow")
    public ResponseEntity<CpuResponseDTO> demoSlow(
            @RequestParam(defaultValue = "40") Integer n,
            @RequestParam(defaultValue = "1") Integer repetitions) {

        // Validación manual
        if (n < 1 || n > 92 || repetitions < 1 || repetitions > 1_000_000) {
            return ResponseEntity.badRequest().build();
        }

        CpuRequestDTO request = new CpuRequestDTO(n, true, repetitions);
        CpuResponseDTO response = cpuService.fib(request);

        log.info("CPU SLOW: n={}, repetitions={}, elapsedMillis={}",
                n, repetitions, response.elapsedMillis());

        return ResponseEntity.ok(response);
    }

    /**
     * Demo rápida para JProfiler - versión optimizada
     */
    @GetMapping("/demo/fast")
    public ResponseEntity<CpuResponseDTO> demoFast(
            @RequestParam(defaultValue = "40") Integer n,
            @RequestParam(defaultValue = "1") Integer repetitions) {

        // Validación manual
        if (n < 1 || n > 92 || repetitions < 1 || repetitions > 1_000_000) {
            return ResponseEntity.badRequest().build();
        }

        CpuRequestDTO request = new CpuRequestDTO(n, false, repetitions);
        CpuResponseDTO response = cpuService.fib(request);

        log.info("CPU FAST: n={}, repetitions={}, elapsedMillis={}",
                n, repetitions, response.elapsedMillis());

        return ResponseEntity.ok(response);
    }
}

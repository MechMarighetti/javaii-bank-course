package com.cursojava.mechjava.controller;

import com.cursojava.mechjava.model.Libro;
import com.cursojava.mechjava.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService service;

    // CRUD
    @GetMapping
    public List<Libro> getAll() { return service.findAll(); }

    @PostMapping
    public Libro create(@RequestBody Libro libro) { return service.save(libro); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) { service.deleteById(id); }

    // Búsqueda por título
    @GetMapping("/buscar")
    public List<Libro> searchByTitulo(@RequestParam String titulo) {
        return service.findByTitulo(titulo);
    }

    // Contador de libros por editorial (Funcionalidad extra 1)
    @GetMapping("/contador")
    public Long countByEditorial(@RequestParam String editorial) {
        return service.countByEditorial(editorial);
    }

    // Estantería por editorial (Funcionalidad extra 2)
    @GetMapping("/estanteria")
    public List<Libro> getByEditorial(@RequestParam String editorial) {
        return service.findByEditorial(editorial);
    }

    // Transformar títulos a MAYÚSCULAS (Funcionalidad extra 3 - inútil y divertida)
    @GetMapping("/uppercase")
    public List<Libro> getUppercaseTitles() {
        List<Libro> libros = service.findAll();
        libros.forEach(libro -> libro.setTitulo(libro.getTitulo().toUpperCase()));
        return libros;
    }
}
package com.cursojava.mechjava.service;

import com.cursojava.mechjava.model.Libro;
import com.cursojava.mechjava.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repository;

    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public void procesarLibrosEnSegundoPlano() {
        // Obtener todos los libros de la base de datos
        List<Libro> libros = repository.findAll();

        // Procesar cada libro de forma concurrente
        List<CompletableFuture<Void>> tareas = libros.stream()
                .map(libro -> CompletableFuture.runAsync(() -> procesarLibro(libro), executorService))
                .toList();

        // Esperar a que todas las tareas terminen
        CompletableFuture.allOf(tareas.toArray(new CompletableFuture[0])).join();

        System.out.println("Procesamiento de libros completado.");
    }

    private void procesarLibro(Libro libro) {
        System.out.println("Procesando libro: " + libro.getTitulo() + " en " + Thread.currentThread().getName());
        try {
            // Simular procesamiento (por ejemplo, verificar stock o actualizar datos)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error al procesar el libro: " + libro.getTitulo());
        }
        System.out.println("Libro procesado: " + libro.getTitulo());
    }

    public List<Libro> findAll() { return repository.findAll(); }
    public Libro save(Libro libro) { return repository.save(libro); }
    public void deleteById(String id) { repository.deleteById(id); }
    public List<Libro> findByTitulo(String titulo) { return repository.findByTituloContainingIgnoreCase(titulo); }
    public List<Libro> findByEditorial(String editorial) { return repository.findByEditorialNombre(editorial); }
    public Long countByEditorial(String editorial) { return repository.countByEditorialNombre(editorial); }
}

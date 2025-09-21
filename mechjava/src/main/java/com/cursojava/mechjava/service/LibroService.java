package com.cursojava.mechjava.service;

import com.cursojava.mechjava.model.Libro;
import com.cursojava.mechjava.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repository;

    public List<Libro> findAll() { return repository.findAll(); }
    public Libro save(Libro libro) { return repository.save(libro); }
    public void deleteById(String id) { repository.deleteById(id); }
    public List<Libro> findByTitulo(String titulo) { return repository.findByTituloContainingIgnoreCase(titulo); }
    public List<Libro> findByEditorial(String editorial) { return repository.findByEditorialNombre(editorial); }
    public Long countByEditorial(String editorial) { return repository.countByEditorialNombre(editorial); }
}

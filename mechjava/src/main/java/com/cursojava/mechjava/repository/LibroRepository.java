package com.cursojava.mechjava.repository;
import com.cursojava.mechjava.model.Libro;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface LibroRepository extends MongoRepository<Libro, String> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByEditorialNombre(String editorial);
    Long countByEditorialNombre(String editorial); // Contador por editorial
}
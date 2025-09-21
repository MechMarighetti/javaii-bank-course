package com.cursojava.mechjava.repository;
import com.cursojava.mechjava.model.Editorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface EditorialRepository extends MongoRepository<Editorial, String> {
    Optional<Editorial> findByNombre(String nombre);
}

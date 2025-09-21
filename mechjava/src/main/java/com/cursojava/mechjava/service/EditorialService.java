package com.cursojava.mechjava.service;
import com.cursojava.mechjava.model.Editorial;
import com.cursojava.mechjava.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository repository;

    public List<Editorial> findAll() { return repository.findAll(); }
    public Editorial save(Editorial editorial) { return repository.save(editorial); }
    public Optional<Editorial> findByNombre(String nombre) { return repository.findByNombre(nombre); }
}
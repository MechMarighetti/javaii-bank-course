package com.cursojava.mechjava.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;

@Data
@Document(collection = "libros")
public class Libro {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private Integer añoPublicacion;
    private String isbn;

    @DBRef
    private Editorial editorial; // Relación con Editorial
}
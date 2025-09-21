package com.cursojava.mechjava.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "editoriales")
public class Editorial {
    @Id
    private String id;
    private String nombre;
    private String pais;
}

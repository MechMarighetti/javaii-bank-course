package com.cursojava.mechjava.controller;

import com.cursojava.mechjava.model.Editorial;
import com.cursojava.mechjava.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
    @Autowired
    private EditorialService service;

    @GetMapping
    public List<Editorial> getAll() { return service.findAll(); }

    @PostMapping
    public Editorial create(@RequestBody Editorial editorial) { return service.save(editorial); }
}
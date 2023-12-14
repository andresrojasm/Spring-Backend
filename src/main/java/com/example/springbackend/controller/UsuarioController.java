package com.example.springbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbackend.model.Usuario;
import com.example.springbackend.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuario/nuevo")
    public Usuario nuevoUsuario(@RequestBody Usuario usuario) {
        
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> getTodosUsuarios() {
        return usuarioRepository.findAll();
    }
 
}

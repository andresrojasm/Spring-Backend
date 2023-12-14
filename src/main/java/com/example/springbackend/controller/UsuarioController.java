package com.example.springbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbackend.exception.UsuarioException;
import com.example.springbackend.model.Usuario;
import com.example.springbackend.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@CrossOrigin("http://localhost:3000")
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
 
    @GetMapping("/usuario/{id}")
    public Usuario getUsuario(@PathVariable int id)
    {
        return usuarioRepository.findById(id)
            .orElseThrow(()->new UsuarioException(id));
    }
    
    @PutMapping("usuario/{id}")
    public Usuario updateusuario(@PathVariable int id, @RequestBody Usuario usuario){
        return usuarioRepository.findById(id)
            .map(u -> {
                u.setNombre(usuario.getNombre());
                u.setUsername(usuario.getUsername());
                u.setEmail(usuario.getEmail());
                return usuarioRepository.save(u);
            })
            .orElseThrow(()-> new UsuarioException(id));
    }

    @DeleteMapping("usuario/{id}")
    public String deleteUsuario(@PathVariable int id){
        if(!usuarioRepository.existsById(id)){
            throw new UsuarioException(id);
        }
        usuarioRepository.deleteById(id);
        return "Usuario " + id +" eliminado.";
    }
}

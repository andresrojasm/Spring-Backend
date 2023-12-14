package com.example.springbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}

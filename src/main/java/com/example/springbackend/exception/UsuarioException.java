package com.example.springbackend.exception;

public class UsuarioException extends RuntimeException{
    public UsuarioException (int id){
        super("No se encontro el usuario con id:" + id);
    }
}

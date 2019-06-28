package com.example.conductor.api.cadastroClientes.exception;

public class ClienteException extends RuntimeException {
    public ClienteException(){
        super("Cliente não encontrado");
    }
}

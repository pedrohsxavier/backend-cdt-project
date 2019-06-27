package com.example.conductor.api.cadastroClientes.Exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(){
        super("Cliente não encontrado");
    }
}

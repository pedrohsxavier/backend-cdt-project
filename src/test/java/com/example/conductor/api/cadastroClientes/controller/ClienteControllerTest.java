package com.example.conductor.api.cadastroClientes.controller;

import com.example.conductor.api.cadastroClientes.model.Cliente;
import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ClienteControllerTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Test
    public void addingTest(){
        //Cenário de sucesso
        Cliente c = new Cliente("Neil", "neil@neil.com", "123456", "(83)99999-8888");

        error.checkThat(c.getSenha(), CoreMatchers.is(CoreMatchers.equalTo("123456")));
        
    }


}

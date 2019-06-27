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
    public void addingTest() throws Exception{
        //Cenário de sucesso
        Cliente c = new Cliente("Neil", "neil@neil.com", "123456", "(83)99999-8888");

        error.checkThat(c.getSenha(), CoreMatchers.is(CoreMatchers.equalTo("123456")));
        error.checkThat(c.getNome(), CoreMatchers.is(CoreMatchers.notNullValue()));

        /* !!Tratando exceções!! */
        /*
        * No ponto possível da exceção:
        * try{
        *   Momento da exceção
        * }catch(Exception e){
        *   Assert.assertThat(e.getMessage(), Corematchers.is("Mensagem de exceção");
        * }
        * Para evitar falso positivo, deve-se incluir o Assert.assertThat("Mensagem") dependendo do que é esperado.
         */
    }


}

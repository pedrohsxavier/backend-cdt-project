package com.example.conductor.api.cadastroClientes.controller;

import com.example.conductor.api.cadastroClientes.builder.ClienteBuilder;
import com.example.conductor.api.cadastroClientes.model.Cliente;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

public class ClienteControllerTest {

    private Cliente c;

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Before
    public void config() {
         c = ClienteBuilder.getCliente().now();
    }

    @Test
    public void addingTest(){

        error.checkThat(c.getNome(), CoreMatchers.is(CoreMatchers.notNullValue()));
        error.checkThat(c.getSenha(), CoreMatchers.is(CoreMatchers.notNullValue()));
        error.checkThat(c.getEmail(), CoreMatchers.is(CoreMatchers.notNullValue()));
        error.checkThat(c.getTelefone(), CoreMatchers.is(CoreMatchers.notNullValue()));
    }

    @Test
    public void blankName(){
        c = ClienteBuilder.getCliente().changeName(null).now();
        Assert.assertNull("Expecting null in input name", c.getNome());
    }

    @Test
    public void nameLengthMinusThanThree(){
        c = ClienteBuilder.getCliente().changeName("K").now();
        int size = c.getNome().length();
        Assert.assertThat("I expect minus than three letters", size, Matchers.lessThan(3));
    }

    @Test
    public void blankPassword(){
        c = ClienteBuilder.getCliente().changePassword(null).now();
        Assert.assertNull("Expecting null in input password", c.getSenha());
    }

    @Test
    public void blankEmail(){
        c = ClienteBuilder.getCliente().changeEmail(null).now();
        Assert.assertThat("Expecting null in input name",
                c.getEmail(), CoreMatchers.is(CoreMatchers.nullValue()));

        c.setEmail("Blobloblo");
        Assert.assertNotNull("Expecting email", c.getEmail());
    }
}

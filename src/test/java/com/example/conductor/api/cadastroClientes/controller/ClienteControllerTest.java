package com.example.conductor.api.cadastroClientes.controller;

import com.example.conductor.api.cadastroClientes.model.Cliente;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import javax.validation.*;
import java.util.Set;

public class ClienteControllerTest {

    private Cliente c;
    private Validator validator;

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Before
    public void config() {
        c = new Cliente();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    public void addingTest(){
        //Cenário de sucesso

        c.setNome("Neil");
        c.setEmail("neil@neil.com");
        c.setSenha("123456");
        c.setTelefone("(83)99999-8888");

        error.checkThat(c.getSenha(), CoreMatchers.is(CoreMatchers.equalTo("123456")));
        error.checkThat(c.getNome(), CoreMatchers.is(CoreMatchers.notNullValue()));


    }
    @Test
    public void blankName() {
        c.setSenha("asdf");
        c.setEmail("neil@neil.com");
        c.setTelefone("(83)99999-8888");
        Set<ConstraintViolation<Cliente>> restrictions = validator.validate(c);

        error.checkThat(restrictions, Matchers.hasSize(1));
    }

    @Test
    public void blankEmail() {
        c.setSenha("asdf");
        c.setNome("Neil");
        c.setTelefone("(83)99999-8888");
        Set<ConstraintViolation<Cliente>> restrictions = validator.validate(c);

        error.checkThat(restrictions, Matchers.hasSize(1));
    }

    @Test
    public void blankPassword() {
        c.setNome("Neil");
        c.setEmail("neil@neil.com");
        c.setTelefone("(83)99999-8888");
        Set<ConstraintViolation<Cliente>> restrictions = validator.validate(c);

        error.checkThat(restrictions, Matchers.hasSize(1));
    }




}

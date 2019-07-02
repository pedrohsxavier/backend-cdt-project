package com.example.conductor.api.cadastroClientes.controller;

import com.example.conductor.api.cadastroClientes.model.Cliente;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import javax.validation.*;
import javax.validation.constraints.Email;

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
     //   ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
     //   this.validator = factory.getValidator();
    }

    @Test
    public void addingTest(){
        //Cenário de sucesso

        c.setNome("Neil");
        c.setEmail("neil@neil.com");
        c.setSenha("123456");
        c.setTelefone("(83)99999-8888");

        error.checkThat(c.getNome(), CoreMatchers.is(CoreMatchers.notNullValue()));
        error.checkThat(c.getSenha(), CoreMatchers.is(CoreMatchers.notNullValue()));
        error.checkThat(c.getEmail(), CoreMatchers.is(CoreMatchers.notNullValue()));
        error.checkThat(c.getTelefone(), CoreMatchers.is(CoreMatchers.notNullValue()));
    }

    @Test
    public void blankName(){
        c.setSenha("asdf");
        c.setEmail("neil@neil.com");
        c.setTelefone("(83)99999-8888");
        Assert.assertNull("Expecting null in input name", c.getNome());
    }

    @Test
    public void nameLengthMinusThanThree(){
        c.setNome("K");
        int size = c.getNome().length();
        Assert.assertThat("I expect minus than three letters", size, Matchers.lessThan(3));
    }

    @Test
    public void blankPassword(){
        c.setNome("Neil");
        c.setEmail("neil@neil.com");
        c.setTelefone("(83)99999-8888");
        Assert.assertNull("Expecting null in input password", c.getSenha());
    }

    @Test
    public void blankEmail(){
        c.setSenha("asdf");
        c.setNome("Neil");
        c.setTelefone("(83)99999-8888");
        Assert.assertThat("Expecting null in input name",
                c.getEmail(), CoreMatchers.is(CoreMatchers.nullValue()));

        c.setEmail("Blobloblo");
        Assert.assertNotNull("Expecting email", c.getEmail());
    }

    /*
    @Test
    public void blankName() {
        c.setSenha("asdf");
        c.setEmail("neil@neil.com");
        c.setTelefone("(83)99999-8888");
        Set<ConstraintViolation<Cliente>> restrictions = validator.validate(c);

        error.checkThat(restrictions, Matchers.hasSize(1));

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
    */
}

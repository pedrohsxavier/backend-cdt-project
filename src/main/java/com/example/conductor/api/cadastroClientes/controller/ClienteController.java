package com.example.conductor.api.cadastroClientes.controller;

import com.example.conductor.api.cadastroClientes.exception.ClienteException;
import com.example.conductor.api.cadastroClientes.model.Cliente;
import com.example.conductor.api.cadastroClientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository dao;

    @GetMapping("/list")
    public List<Cliente> listAll(){
        return dao.findAll();
    }

    @PostMapping("/create")
    public Cliente create(@RequestBody Cliente cliente){
        return dao.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        dao.deleteById(id);
    }

    @GetMapping("/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Long id) throws ClienteException {
        return dao.findById(id).orElseThrow(() -> new ClienteException());
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente)
            throws ClienteException {
        Cliente c = dao.findById(id).orElseThrow(() -> new ClienteException());
        c.setNome(cliente.getNome());
        c.setDataNascimento(cliente.getDataNascimento());
        c.setEmail(cliente.getEmail());
        c.setTelefone(cliente.getTelefone());
        c.setSenha(cliente.getSenha());
        c.setEndereco(cliente.getEndereco());
        return dao.save(c);
    }

}

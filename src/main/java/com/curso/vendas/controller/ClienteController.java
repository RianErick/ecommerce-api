package com.curso.vendas.controller;

import com.curso.vendas.model.Cliente;
import com.curso.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @GetMapping("/consulta")
    public List<Cliente> consultarClientes() {
        return clienteRepository.findAll();
    }
    @GetMapping("/consulta/{id}")
    public ResponseEntity <Cliente> consultarPeloId(@PathVariable Integer id ) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElseThrow( () -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Cliente nao encontrado"));
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity <Cliente> editarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        if(!clienteRepository.existsById(id)){
          return  ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <Void> deletarCliente(@PathVariable Integer id){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
           clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/nomes/ordem")
    public List<Cliente> OrdenarNomes() {
        return clienteRepository.findByOrderByNome();
    }
}
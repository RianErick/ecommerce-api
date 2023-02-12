package com.curso.vendas.controller;

import com.curso.vendas.model.Cliente;
import com.curso.vendas.model.Produto;
import com.curso.vendas.repository.ProdutoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/listar")
    public List <Produto> listarProdutos(){
        return produtoRepository.findAll();
    }
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar( @RequestBody Produto produto){
      return produtoRepository.save(produto);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity <Produto> buscarPeloId(@PathVariable Integer id){
        return produtoRepository.findById(id)
                .map(produto -> ResponseEntity.ok(produto))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID DO CLIENTE NAO ENCONTRADO"));
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity <Produto> editar(@PathVariable Integer id , @RequestBody Produto produto){
        if (!produtoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        produto.setId(id);
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Integer id){
        if(!produtoRepository.existsById(id)){
            ResponseEntity.notFound().build();
        }
        produtoRepository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
}

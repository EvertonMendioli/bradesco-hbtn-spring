package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService produtoService = null;


    public ProdutoController(ProdutoService produtoService) {
        Produto produto = new Produto();
        produto.setId(2L);
        produto.setNome("Teste");
        produto.setPreco(20.2);

        produtoService.adicionarProduto(produto);


    }


    @GetMapping
    public List<Produto> listarProdutos() {
       return  produtoService.listarProdutos();
    }


    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
       return  produtoService.adicionarProduto(produto);
    }


    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
       return  produtoService.atualizarProduto(id, produto);
    }


    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
       return Boolean.toString(produtoService.deletarProduto(id));
    }
}

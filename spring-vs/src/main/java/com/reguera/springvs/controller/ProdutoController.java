package com.reguera.springvs.controller;

import java.util.List;
import java.util.Optional;

import com.reguera.springvs.model.Produto;
import com.reguera.springvs.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
    @ApiOperation(value = "Retorna uma lista de Produtos")
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}

	@GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma lista de Produtos por ID")
	public Optional<Produto> listarPorId(@PathVariable(value = "id") Long id){
		return produtoRepository.findById(id);
	}

	@GetMapping("/descricao")
    @ApiOperation(value = "Retorna uma lista de Produtos por Descrição")
	public List<Produto> buscarDescricao(@RequestParam(name = "descricao") String descricao){
		return produtoRepository.findByDescricaoContaining(descricao);
		 
	}


	@PostMapping
    @ApiOperation(value = "Adiciona um Produto na lista")
	public Produto adicionar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um Produto por ID")
	public void deleteProduto(@PathVariable("id") Long id){
		produtoRepository.deleteById(id);
	}

	@PutMapping
    @ApiOperation(value = "Altera um Produto")
	public Produto alterarProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}

}


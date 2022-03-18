package com.reguera.springvs.controller;

import java.util.List;

import com.reguera.springvs.model.Marca;
import com.reguera.springvs.repository.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/marca")
public class MarcaController {

        @Autowired
        private MarcaRepository marcaRepository;

        @GetMapping
        @ApiOperation(value = "Retorna uma Lista das Marcas")
        public List<Marca> listar(){
            return marcaRepository.findAll();
        }
        @PostMapping
        @ApiOperation(value = "Adiciona uma Marca na lista")
        public Marca marca_adicionar(@RequestBody Marca marca){
            return marcaRepository.save(marca);
        }
}

package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return pessoaService.salvar(pessoa);
    }

    public Pessoa pegarPorId(Integer id){
        return pessoaService.pegarPorId(id);
    }

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaService.listar();
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id){
        pessoaService.deletar(id);
    }

    @PutMapping("{id}")
    public Pessoa atualizar(@RequestBody Pessoa pessoa, @PathVariable Integer id){
        return pessoaService.atualizar(id, pessoa);
    }
}

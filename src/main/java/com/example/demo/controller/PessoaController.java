package com.example.demo.controller;

import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @PostMapping
    public Pessoa cadastrar(@RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> listar(){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Integer id){
        Pessoa pessoa = repository.findById(id).get();
        repository.delete(pessoa);
    }

    @PutMapping("{id}")
    public Pessoa atualizar(@RequestBody Pessoa request, @PathVariable Integer id){
        Pessoa pessoa = repository.findById(id).get();
        pessoa.setNome(request.getNome());
        pessoa.setEmail(request.getEmail());
        pessoa.setCpf(request.getCpf());
        pessoa.setIdade(request.getIdade());
        return repository.save(pessoa);

    }
}

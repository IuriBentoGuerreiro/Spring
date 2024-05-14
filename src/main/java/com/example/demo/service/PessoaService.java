package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public Pessoa pegarPorId(Integer id){
        return pessoaRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("recurso não encontrado")
        );
    }

    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }

    public Pessoa atualizar(Integer id, Pessoa pessoa){
        Pessoa pessoaSalva = pegarPorId(id);
        BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
        return pessoaSalva;
    }

    public void deletar(Integer id){
        pessoaRepository.deleteById(id);
    }
}

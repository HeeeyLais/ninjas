package br.com.etec.ninjas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninjas.model.Missao;
import br.com.etec.ninjas.service.MissaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/missoes")
public class missaoController {
    
    @Autowired
    private MissaoService missaoService;

    @PostMapping
    public Missao cadastrarMissao (@Valid @RequestBody Missao missao){
        return missaoService.cadastrarMissao(missao);
    }

    @GetMapping
    public List <Missao> listarMissoes(){
        return missaoService.listarMissoes();
    }

    @GetMapping ("/{dificuldade}")
    public List <Missao> buscarMissaoPorDificuldade(@PathVariable String dificuldade){
        return missaoService.buscarMissaoPorDificuldade(dificuldade);
    }

    @PutMapping ("/{id}")
    public Missao atualizarMissao (@PathVariable Long id, 
        @Valid @RequestBody Missao missao) {
            return missaoService.atualizarMissao(id, missao);
        }

    @DeleteMapping ("/{id}")
        public void deletarMissao (@PathVariable Long id){
            missaoService.deletarMissao(id);
        }
}

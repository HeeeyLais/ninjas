package br.com.etec.ninjas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninjas.model.Ninja;
import br.com.etec.ninjas.service.NinjaService;
import jakarta.validation.Valid;

// recebe requisições HTTP e retorna respostas no formato JSON
@RestController
// definir a rota de acesso(endpoint) de uma controller/método = mapear endpoints da API
@RequestMapping("/ninjas") //localhost:8080/ninjas
public class NinjaController {
    
    //importar service para que a controller possa receber a conexão e passa-la adiante
    @Autowired
    private NinjaService ninjaService;

    //post = cadastrar/criar novos dados no sistema
    @PostMapping
        // valid pra refinamento de erro 
    public Ninja cadastrarNinja (@Valid @RequestBody Ninja ninja){
        return ninjaService.cadastrarNinja(ninja);
            // cadastrarNinja = método criado la na service
    }

    @GetMapping
    public List<Ninja> listarNinjas(){
        return ninjaService.listarNinjas();
    }

        // get passando o id na url
    @GetMapping("/id/{id}")
                                            // converte o valor no get e armazena em id
    public Optional<Ninja> pesquisarNinja(@PathVariable Long id){
        return ninjaService.pesquisarNinjaPorId(id);
    }

    @GetMapping("/nomecompleto/{nome}")
    public Ninja pesquisarNinjaPorNome(@PathVariable String nome){
        return ninjaService.pesquisarNinjaPorNome(nome);
    }

    @GetMapping("/nome/{nome}")
    public List<Ninja> buscarNinjaPorParteDoNome(@PathVariable String nome){
        return ninjaService.buscarNinjaPorPartesDoNome(nome);
    }

}

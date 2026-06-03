package br.com.etec.ninjas.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}

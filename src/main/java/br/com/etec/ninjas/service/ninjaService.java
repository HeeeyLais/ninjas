package br.com.etec.ninjas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.ninjas.model.Ninja;
import br.com.etec.ninjas.repository.NinjaRepository;

//@ service classe pertence a cama de serviços da aplicação, responsável pelas regras de negócio = gerencia automaticamente
@Service
public class ninjaService {
    
    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarNinja (Ninja ninja){
        return ninjaRepository.save(ninja);
    }
}

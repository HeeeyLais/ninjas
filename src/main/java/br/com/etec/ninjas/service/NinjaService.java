package br.com.etec.ninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etec.ninjas.model.Ninja;
import br.com.etec.ninjas.repository.NinjaRepository;

//@ service classe pertence a cama de serviços da aplicação, responsável pelas regras de negócio = gerencia automaticamente
@Service
public class NinjaService {
    
    @Autowired
    private NinjaRepository ninjaRepository;

    public Ninja cadastrarNinja (Ninja ninja){
        return ninjaRepository.save(ninja);
    }

    public List<Ninja> listarNinjas(){
        return ninjaRepository.findAll();
    }
            // optional = representa um valor que pode OU NÃO existir
                // Long id = parâmetro de pesquisa
    public Optional<Ninja> pesquisarNinjaPorId(Long id) {
        return ninjaRepository.findById(id);
                                // findbyid = método herdado
    }

    public Ninja pesquisarNinjaPorNome(String nome){
        return ninjaRepository.findByNome(nome);
    }

    public List<Ninja> buscarNinjaPorPartesDoNome(String nome){
        return ninjaRepository.findByNomeContaining(nome);
    }
}

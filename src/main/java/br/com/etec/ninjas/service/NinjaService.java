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

                                // Long id = id do ninja que vai ser alterado
                                        // Ninja ninjaAtualizado = objeto com novos dados
    public Ninja atualizarNinja(Long id, Ninja ninjaAtualizado){
        Optional <Ninja> ninjaCadastrado = ninjaRepository.findById(id);
        // optional = pode ser que o ninja exista ou não
                            // se o ninja foi encontrado | is present é método herdado do optional
        if (ninjaCadastrado.isPresent()) {
            Ninja ninja = ninjaCadastrado.get();
            // get = busco, set = insiro
            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setCpf(ninjaAtualizado.getCpf());
            ninja.setEmail(ninjaAtualizado.getEmail());
                // sempre passar todos os atributos que PODEM ser atualizados
            
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    // void = sem retorno nenhum
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }
}

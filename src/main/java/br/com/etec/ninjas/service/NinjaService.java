package br.com.etec.ninjas.service;

import br.com.etec.ninjas.model.Ninja;
import br.com.etec.ninjas.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository repository;

    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    public List<Ninja> findAll() {
        return repository.findAll();
    }

    public Optional<Ninja> findById(Long id) {
        return repository.findById(id);
    }

    public Ninja create(Ninja ninja) {
        return repository.save(ninja);
    }

    public Optional<Ninja> update(Long id, Ninja ninja) {
        return repository.update(id, ninja);
    }

    public boolean delete(Long id) {
        return repository.deleteById(id);
    }
}

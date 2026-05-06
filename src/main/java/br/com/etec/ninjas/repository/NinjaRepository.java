package br.com.etec.ninjas.repository;

import br.com.etec.ninjas.model.Ninja;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class NinjaRepository {

    private final List<Ninja> database = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Ninja> findAll() {
        return new ArrayList<>(database);
    }

    public Optional<Ninja> findById(Long id) {
        return database.stream().filter(n -> n.getId().equals(id)).findFirst();
    }

    public Ninja save(Ninja ninja) {
        ninja.setId(idGenerator.getAndIncrement());
        database.add(ninja);
        return ninja;
    }

    public Optional<Ninja> update(Long id, Ninja updated) {
        return findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            existing.setCpf(updated.getCpf());
            return existing;
        });
    }

    public boolean deleteById(Long id) {
        return database.removeIf(n -> n.getId().equals(id));
    }
}

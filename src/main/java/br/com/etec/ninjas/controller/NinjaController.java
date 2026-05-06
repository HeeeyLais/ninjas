package br.com.etec.ninjas.controller;

import br.com.etec.ninjas.model.Ninja;
import br.com.etec.ninjas.service.NinjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Ninja> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ninja> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ninja create(@RequestBody Ninja ninja) {
        return service.create(ninja);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ninja> update(@PathVariable Long id, @RequestBody Ninja ninja) {
        return service.update(id, ninja)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

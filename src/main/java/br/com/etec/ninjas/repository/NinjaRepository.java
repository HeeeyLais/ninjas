package br.com.etec.ninjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etec.ninjas.model.Ninja;

public interface NinjaRepository extends JpaRepository <Ninja, Long> {
    // extends JpaRepository = herda do JpaRepo todas as operações(querrys, tipo select, salvar, buscar) sem precisar  implementa-los manualmente
}

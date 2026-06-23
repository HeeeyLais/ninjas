package br.com.etec.ninjas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.ninjas.service.MissaoService;

@RestController
@RequestMapping("/missoes")
public class missaoController {
    
    @Autowired
    private MissaoService missaoService;
}

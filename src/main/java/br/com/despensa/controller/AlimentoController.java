package br.com.despensa.controller;

import br.com.despensa.model.entity.Alimento;
import br.com.despensa.service.AlimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/alimentos") //padrao de endpoints é no plural
public class AlimentoController {
    AlimentoService alimentoService;

    public AlimentoController(AlimentoService alimentoService) {
        this.alimentoService = alimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Alimento>> getAlimentos() {
        List<Alimento> listaAlimentos =  this.alimentoService.getAlimentos();
        return ResponseEntity.ok(listaAlimentos);
    }



}

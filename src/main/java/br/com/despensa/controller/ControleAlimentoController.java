package br.com.despensa.controller;

import br.com.despensa.service.ControleAlimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/controles-alimentos")
@RequiredArgsConstructor
public class ControleAlimentoController {

    private final ControleAlimentoService controleAlimentoService;

}

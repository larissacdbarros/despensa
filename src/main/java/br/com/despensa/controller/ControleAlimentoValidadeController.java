package br.com.despensa.controller;

import br.com.despensa.service.ControleAlimentoValidadeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/controles-alimentos-validades")
@AllArgsConstructor
public class ControleAlimentoValidadeController {

    private final ControleAlimentoValidadeService controleAlimentoValidadeService;

}

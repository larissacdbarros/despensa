package br.com.despensa.controller;

import br.com.despensa.service.ControleAlimentoValidadeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/controles-alimentos-validades")
@RequiredArgsConstructor
public class ControleAlimentoValidadeController {

    private final ControleAlimentoValidadeService controleAlimentoValidadeService;

}

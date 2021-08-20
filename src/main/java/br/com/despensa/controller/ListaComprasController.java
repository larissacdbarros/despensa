package br.com.despensa.controller;

import br.com.despensa.service.ListaComprasService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/listas-compras")
@AllArgsConstructor
public class ListaComprasController {

    private final ListaComprasService listaComprasService;

}

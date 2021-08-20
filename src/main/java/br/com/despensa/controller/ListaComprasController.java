package br.com.despensa.controller;

import br.com.despensa.service.ListaComprasService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/listas-compras")
@RequiredArgsConstructor
public class ListaComprasController {

    private final ListaComprasService listaComprasService;

}

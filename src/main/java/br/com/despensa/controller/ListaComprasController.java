package br.com.despensa.controller;

import br.com.despensa.model.dto.ListaComprasReqDTO;
import br.com.despensa.model.dto.ListaComprasRespDTO;
import br.com.despensa.service.ListaComprasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/listas-compras")
@RequiredArgsConstructor
@Api(tags = "Lista de Compras", description = "Pega todos as Listas de Compras ou apenas uma delas pelo Id, salva uma Lista de Compras, " +
        "atualiza a Lista de Compras e deleta uma Lista de Compras.")
public class ListaComprasController {

    private final ListaComprasService listaComprasService;

    @GetMapping
    @ApiOperation(value = "Pega todas as Listas de Compras.")
    public ResponseEntity<List<ListaComprasRespDTO>> getAll(){
        List<ListaComprasRespDTO> result  = this.listaComprasService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pega uma Lista de Compras pelo Id.")
    public ResponseEntity<ListaComprasRespDTO> getById(@ApiParam(name = "Id", required = true)@PathVariable Long id){
       ListaComprasRespDTO result = this.listaComprasService.getById(id);
       return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "Salva uma Lista de Compras.")
    public ResponseEntity<ListaComprasRespDTO> save(@ApiParam(name = "ListaComprasDTO", required = true)@RequestBody ListaComprasReqDTO listaComprasReqDTO){
        ListaComprasRespDTO result = this.listaComprasService.save(listaComprasReqDTO);
        return ResponseEntity.ok(result);
    }
    
    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza uma Lista de Compras.")
    public  ResponseEntity<ListaComprasRespDTO> update(@ApiParam(name = "ListaComprasDTO", required = true)@PathVariable Long id, @RequestBody ListaComprasReqDTO listaComprasReqDTO){
        ListaComprasRespDTO result = this.listaComprasService.update(id, listaComprasReqDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta uma Lista de Compras.")
    public ResponseEntity<Void> delete(@ApiParam(name = "Id", required = true)@PathVariable Long id){
        this.listaComprasService.delete(id);
        return ResponseEntity.ok().build();
    }

}

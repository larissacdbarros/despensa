package br.com.despensa.controller;

import br.com.despensa.model.dto.ListaComprasDTO;
import br.com.despensa.model.entity.ListaCompras;
import br.com.despensa.service.ListaComprasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<ListaComprasDTO>> getAll(){
        List<ListaComprasDTO> result  = this.listaComprasService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pega uma Lista de Compras pelo Id.")
    public ResponseEntity<ListaComprasDTO> getById(@ApiParam(name = "Id", required = true)@PathVariable Long id){
       ListaComprasDTO result = this.listaComprasService.getById(id);
       return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "Salva uma Lista de Compras.")
    public ResponseEntity<ListaComprasDTO> save(@ApiParam(name = "ListaComprasDTO", required = true)@RequestBody ListaComprasDTO listaComprasDTO){
        ListaComprasDTO result = this.listaComprasService.save(listaComprasDTO);
        return ResponseEntity.ok(result);
    }
    
    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza uma Lista de Compras.")
    public  ResponseEntity<ListaComprasDTO> update(@ApiParam(name = "ListaComprasDTO", required = true)@PathVariable Long id, @RequestBody ListaComprasDTO listaComprasDTO){
        ListaComprasDTO result = this.listaComprasService.update(id, listaComprasDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta uma Lista de Compras.")
    public ResponseEntity<Void> delete(@ApiParam(name = "Id", required = true)@PathVariable Long id){
        this.listaComprasService.delete(id);
        return ResponseEntity.ok().build();
    }

}

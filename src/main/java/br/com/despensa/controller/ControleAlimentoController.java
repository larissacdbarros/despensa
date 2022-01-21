package br.com.despensa.controller;

import br.com.despensa.model.dto.ControleAlimentoReqDTO;
import br.com.despensa.model.dto.ControleAlimentoRespDTO;
import br.com.despensa.service.ControleAlimentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/controles-alimentos")
@RequiredArgsConstructor
@Api(tags = "Controle Alimento", description = "Pega todos os Controles de Alimentos ou apenas um deles pelo Id, salva um Controle de Alimento, " +
        "atualiza o Controle de Alimento e deleta um Controle de Alimento.")
public class ControleAlimentoController {

    private final ControleAlimentoService controleAlimentoService;

    @GetMapping
    @ApiOperation(value = "Pega todos os Controles de Alimentos.")
    public ResponseEntity<List<ControleAlimentoRespDTO>> getAll(){
        List<ControleAlimentoRespDTO> listaControleAlimento = this.controleAlimentoService.getAll();
        return ResponseEntity.ok(listaControleAlimento);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pega um Controle de Alimento pelo Id")
    public ResponseEntity<ControleAlimentoRespDTO> getById (@ApiParam(name = "Id", required = true)@PathVariable Long id){
        ControleAlimentoRespDTO result = this.controleAlimentoService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "Salva um Controle de Alimento")
    public ResponseEntity<ControleAlimentoRespDTO> save(@ApiParam(name = "ControleAlimentoDTO", required = true)@RequestBody ControleAlimentoReqDTO controleAlimentoReqDTO){
        ControleAlimentoRespDTO result = this.controleAlimentoService.save(controleAlimentoReqDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um Controle Alimento")
    public ResponseEntity<ControleAlimentoRespDTO> update(@ApiParam(name = "ControleAlimentoDTO", required = true)@PathVariable Long id, @RequestBody ControleAlimentoReqDTO controleAlimentoReqDTO){
        ControleAlimentoRespDTO result = this.controleAlimentoService.update(id, controleAlimentoReqDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta um Controle Alimento")
    public ResponseEntity<Void> delete(@ApiParam(name = "Id", required = true)@PathVariable Long id){
        this.controleAlimentoService.delete(id);
        return ResponseEntity.ok().build();
    }
}

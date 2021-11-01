package br.com.despensa.controller;

import br.com.despensa.model.dto.ControleAlimentoValidadeReqDTO;
import br.com.despensa.model.dto.ControleAlimentoValidadeRespDTO;
import br.com.despensa.service.ControleAlimentoValidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/controles-alimentos-validades")
@RequiredArgsConstructor
@Api(tags = "Controle Alimento Validade", description = "Pega todos os Controles de Alimentos Validade ou apenas um deles pelo Id, salva um Controle de Alimento Validade, " +
        "atualiza o Controle de Alimento Validade e deleta um Controle de Alimento Validade.")
public class ControleAlimentoValidadeController {

    private final ControleAlimentoValidadeService controleAlimentoValidadeService;

    @GetMapping
    @ApiOperation(value = "Pega todos os Controles de Alimentos Validade.")
    public ResponseEntity<List<ControleAlimentoValidadeRespDTO>> getAll(){
        List<ControleAlimentoValidadeRespDTO> controleAlimentoValidadeDTOList = this.controleAlimentoValidadeService.getAll();
        return ResponseEntity.ok(controleAlimentoValidadeDTOList);
    }

    @GetMapping(value = "{/id}")
    @ApiOperation(value = "Pega um Controle de Alimento Validade pelo Id")
    public ResponseEntity<ControleAlimentoValidadeRespDTO> getById(@ApiParam(name = "Id", required = true)@PathVariable Long id){
        ControleAlimentoValidadeRespDTO result = this.controleAlimentoValidadeService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "Salva um Controle de Alimento Validade")
    public ResponseEntity<ControleAlimentoValidadeRespDTO> save (@ApiParam(name = "ControleAlimentoValidadeDTO", required = true)@RequestBody ControleAlimentoValidadeReqDTO controleAlimentoValidadeReqDTO){
        ControleAlimentoValidadeRespDTO result = this.controleAlimentoValidadeService.save(controleAlimentoValidadeReqDTO);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um Controle Alimento Validade")
   public ResponseEntity<ControleAlimentoValidadeRespDTO> update(@ApiParam(name = "ControleAlimentoValidadeDTO", required = true)@PathVariable Long id, @RequestBody ControleAlimentoValidadeReqDTO controleAlimentoValidadeReqDTO){
        ControleAlimentoValidadeRespDTO result =  this.controleAlimentoValidadeService.update(id, controleAlimentoValidadeReqDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta um Controle Alimento Validade")
    public ResponseEntity<Void> delete(@ApiParam(name = "Id", required = true)@PathVariable Long id){
        this.controleAlimentoValidadeService.delete(id);
        return ResponseEntity.ok().build();
    }

}

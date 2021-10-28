package br.com.despensa.controller;

import br.com.despensa.model.dto.ControleAlimentoDTO;
import br.com.despensa.model.dto.ControleAlimentoValidadeDTO;
import br.com.despensa.model.entity.ControleAlimentoValidade;
import br.com.despensa.service.ControleAlimentoValidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
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
    public ResponseEntity<List<ControleAlimentoValidadeDTO>> getAll(){
        List<ControleAlimentoValidadeDTO> controleAlimentoValidadeDTOList = this.controleAlimentoValidadeService.getAll();
        return ResponseEntity.ok(controleAlimentoValidadeDTOList);
    }

    @GetMapping(value = "{/id}")
    @ApiOperation(value = "Pega um Controle de Alimento Validade pelo Id")
    public ResponseEntity<ControleAlimentoValidadeDTO> getById(@ApiParam(name = "Id", required = true)@PathVariable Long id){
        ControleAlimentoValidadeDTO result = this.controleAlimentoValidadeService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "Salva um Controle de Alimento Validade")
    public ResponseEntity<ControleAlimentoValidadeDTO> save (@ApiParam(name = "ControleAlimentoValidadeDTO", required = true)@RequestBody ControleAlimentoValidadeDTO controleAlimentoValidadeDTO){
        ControleAlimentoValidadeDTO result = this.controleAlimentoValidadeService.save(controleAlimentoValidadeDTO);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um Controle Alimento Validade")
   public ResponseEntity<ControleAlimentoValidadeDTO> update(@ApiParam(name = "ControleAlimentoValidadeDTO", required = true)@PathVariable Long id, @RequestBody ControleAlimentoValidadeDTO controleAlimentoValidadeDTO){
        ControleAlimentoValidadeDTO result =  this.controleAlimentoValidadeService.update(id, controleAlimentoValidadeDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta um Controle Alimento Validade")
    public ResponseEntity<Void> delete(@ApiParam(name = "Id", required = true)@PathVariable Long id){
        this.controleAlimentoValidadeService.delete(id);
        return ResponseEntity.ok().build();
    }

}

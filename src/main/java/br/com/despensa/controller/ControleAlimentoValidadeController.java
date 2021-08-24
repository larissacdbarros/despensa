package br.com.despensa.controller;

import br.com.despensa.model.dto.ControleAlimentoDTO;
import br.com.despensa.model.dto.ControleAlimentoValidadeDTO;
import br.com.despensa.model.entity.ControleAlimentoValidade;
import br.com.despensa.service.ControleAlimentoValidadeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/controles-alimentos-validades")
@RequiredArgsConstructor
public class ControleAlimentoValidadeController {

    private final ControleAlimentoValidadeService controleAlimentoValidadeService;

    @GetMapping
    public ResponseEntity<List<ControleAlimentoValidadeDTO>> getAll(){
        List<ControleAlimentoValidadeDTO> controleAlimentoValidadeDTOList = this.controleAlimentoValidadeService.getAll();
        return ResponseEntity.ok(controleAlimentoValidadeDTOList);
    }

    @GetMapping(value = "{/id}")
    public ResponseEntity<ControleAlimentoValidadeDTO> getById(@PathVariable Long id){
        ControleAlimentoValidadeDTO result = this.controleAlimentoValidadeService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ControleAlimentoValidadeDTO> save (@RequestBody ControleAlimentoValidadeDTO controleAlimentoValidadeDTO){
        ControleAlimentoValidadeDTO result = this.controleAlimentoValidadeService.save(controleAlimentoValidadeDTO);
        return ResponseEntity.ok(result);

    }

    @PutMapping(value = "/{id}")
   public ResponseEntity<ControleAlimentoValidadeDTO> update(@PathVariable Long id, @RequestBody ControleAlimentoValidadeDTO controleAlimentoValidadeDTO){
        ControleAlimentoValidadeDTO result =  this.controleAlimentoValidadeService.update(id, controleAlimentoValidadeDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.controleAlimentoValidadeService.delete(id);
        return ResponseEntity.ok().build();
    }

}

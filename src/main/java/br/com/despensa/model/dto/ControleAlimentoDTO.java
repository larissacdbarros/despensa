package br.com.despensa.model.dto;

import br.com.despensa.model.entity.Alimento;
import br.com.despensa.model.entity.ControleAlimentoValidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleAlimentoDTO {
    private Long id;
    private AlimentoDTO alimento;
    private List<ControleAlimentoValidadeDTO> controlesAlimentoValidade;
    private Double quantidadeMinima;
    private Double quantidadeIdeal;
    private Double quantidadeAtual;

}

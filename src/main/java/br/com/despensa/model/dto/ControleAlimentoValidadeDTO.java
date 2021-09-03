package br.com.despensa.model.dto;


import br.com.despensa.model.entity.ControleAlimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleAlimentoValidadeDTO {
    private Long id;
    private ControleAlimento controleAlimento;
    private String dataValidade;
}

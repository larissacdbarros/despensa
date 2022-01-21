package br.com.despensa.model.dto;

import br.com.despensa.model.entity.Alimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlimentoReqDTO {
    private String nome;
    private Double gramatura;

}

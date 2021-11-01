package br.com.despensa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlimentoRespDTO {
    private Long id;
    private String nome;
    private Double gramatura;
}

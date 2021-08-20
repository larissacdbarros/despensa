package br.com.despensa.model.dto;

import br.com.despensa.model.entity.ControleAlimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaComprasDTO {
    private Long id;
    private List<ControleAlimento> controlesAlimentos;
    private String nome;
}

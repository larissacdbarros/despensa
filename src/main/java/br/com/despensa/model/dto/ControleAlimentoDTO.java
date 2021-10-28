package br.com.despensa.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ControleAlimentoDTO", description = "Contém um alimento e as informações das quantidades mínima, ideal e atual, deste. " +
        "Contém também os controles das validades dos alimentos. ")
public class ControleAlimentoDTO {
    @ApiModelProperty(value = "Id do controle alimento.")
    private Long id;

    @ApiModelProperty(value = "Id do alimento.")
    private AlimentoDTO alimento;

    @ApiModelProperty(value = "Lista de controles das validades dos alimentos.")
    private List<ControleAlimentoValidadeDTO> controlesAlimentoValidade;

    @ApiModelProperty(value = "Quantidade mínima do alimento .")
    private Double quantidadeMinima;

    @ApiModelProperty(value = "Quantidade ideal do alimento .")
    private Double quantidadeIdeal;

    @ApiModelProperty(value = "Quantidade atual do alimento .")
    private Double quantidadeAtual;

}

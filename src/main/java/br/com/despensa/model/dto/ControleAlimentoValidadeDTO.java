package br.com.despensa.model.dto;


import br.com.despensa.model.entity.ControleAlimento;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ControleAlimentoValidadeDTO", description = "Contém a data de validade de um alimento.")
public class ControleAlimentoValidadeDTO {

    @ApiModelProperty(value = "Id do controle alimento validade.")
    private Long id;

    @ApiModelProperty(value = "Alimento.")
    private ControleAlimento controleAlimento;

    @ApiModelProperty(value = "Data de validade do alimento.")
    private String dataValidade;
}

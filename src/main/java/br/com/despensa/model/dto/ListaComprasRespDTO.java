package br.com.despensa.model.dto;

import br.com.despensa.model.entity.ControleAlimento;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ListaDeComprasDTO", description = "Contém a lista de alimentos a serem comprados.")
public class ListaComprasRespDTO {

    @ApiModelProperty(value = "Id da Lista de Compras.")
    private Long id;

    @ApiModelProperty(value = "Lista de Alimentos.")
    private List<ControleAlimento> controlesAlimentos;

    @ApiModelProperty(value = "Nome da Lista de Compras.")
    private String nome;
}

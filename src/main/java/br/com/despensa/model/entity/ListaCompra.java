package br.com.despensa.model.entity;

import br.com.despensa.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_LISTA_COMPRA", schema = Constants.SCHEMA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaCompra {

    @Id
    @Column(name = "ID_LISTA_COMPRA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "RL_LISTA_COMP_CTRL_ALIMENTOS",
            schema = Constants.SCHEMA,
            inverseJoinColumns = @JoinColumn(name = "ID_CONTROLE_ALIMENTO"),
            joinColumns = @JoinColumn(name = "ID_LISTA_COMPRA"))
    private List<ControleAlimento> controlesAlimentos;

    @Column(name = "DS_NOME")
    private String nome;

}
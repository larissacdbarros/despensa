package br.com.despensa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_LISTA_COMPRAS", schema = "DESPENSA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaCompras {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lista_compras")
    @SequenceGenerator(name = "seq_lista_compras", sequenceName = "seq_lista_compras")
    private Long id;

    @ManyToMany
    @JoinTable(name = "RL_LISTA_COMP_CTRL_ALIMENTOS",
            schema = "DESPENSA",
            inverseJoinColumns = @JoinColumn(name = "ID_CONTROLE_ALIMENTOS"),
            joinColumns = @JoinColumn(name = "ID_LISTA_COMPRAS"))
    private List<ControleAlimento> controlesAlimentos;

    @Column(name = "NOME")
    private String nome;

}
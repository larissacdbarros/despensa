package br.com.despensa.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_LISTA_COMPRAS", schema = "DESPENSA")
public class ListaCompras {

    @Id
    @Column (name = "ID")
    public Long id;

    @ManyToMany
    @JoinTable(name = "RL_LISTA_COMP_CTRL_ALIMENTOS",
            schema = "DESPENSA",
            inverseJoinColumns = @JoinColumn (name= "ID_CONTROLE_ALIMENTOS"),
            joinColumns = @JoinColumn (name= "ID_LISTA_COMPRAS"))
    private List<ControleAlimento> controlesAlimentos;

    @Column(name= "NOME")
    private String nome;


}
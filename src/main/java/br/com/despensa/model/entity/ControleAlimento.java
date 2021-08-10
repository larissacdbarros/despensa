package br.com.despensa.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CONTROLE_ALIMENTOS", schema = "DESPENSA")
public class ControleAlimento {
    @Id
    @Column (name = "ID")
    public Long id;

    @OneToOne
    @JoinColumn (name = "ID_ALIMENTO")
    private Alimento alimento;

    @OneToMany
    private List<ControleAlimentoValidade> controlesAlimentoValidade;

    @Column(name = "QUANTIDADE_MINIMA")
    private Double quantidadeMinima;

    @Column (name = "QUANTIDADE_IDEAL")
    private Double quantidadeIdeal;

    @Column(name = "QUANTIDADE_ATUAL")
    private Double quantidadeAtual;


}

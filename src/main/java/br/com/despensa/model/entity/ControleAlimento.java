package br.com.despensa.model.entity;

import br.com.despensa.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CONTROLE_ALIMENTO", schema = Constants.SCHEMA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleAlimento {

    @Id
    @Column (name = "ID_CONTROLE_ALIMENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DIZ QUE É O BANCO QUEM VAI GERAR
    private Long id;

    @OneToOne
    @JoinColumn (name = "ID_ALIMENTO")
    private Alimento alimento;

    @OneToMany(mappedBy = "controleAlimento", cascade = CascadeType.ALL)
    private List<ControleAlimentoValidade> controlesAlimentoValidade;

    @Column(name = "QTD_QUANTIDADE_MINIMA")
    private Double quantidadeMinima;

    @Column (name = "QTD_QUANTIDADE_IDEAL")
    private Double quantidadeIdeal;

    @Column(name = "QTD_QUANTIDADE_ATUAL")
    private Double quantidadeAtual;

}

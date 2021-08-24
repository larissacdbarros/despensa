package br.com.despensa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CONTROLE_ALIMENTOS", schema = "DESPENSA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleAlimento {

    @Id
    @Column (name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_controleAlimento")
    @SequenceGenerator(name = "seq_controleAlimento", sequenceName = "seq_controleAlimento")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "ID_ALIMENTO", referencedColumnName = "ID")
    private Alimento alimento;

    @OneToMany(mappedBy = "controleAlimento", cascade = CascadeType.ALL)
    private List<ControleAlimentoValidade> controlesAlimentoValidade;

    @Column(name = "QUANTIDADE_MINIMA")
    private Double quantidadeMinima;

    @Column (name = "QUANTIDADE_IDEAL")
    private Double quantidadeIdeal;

    @Column(name = "QUANTIDADE_ATUAL")
    private Double quantidadeAtual;

}

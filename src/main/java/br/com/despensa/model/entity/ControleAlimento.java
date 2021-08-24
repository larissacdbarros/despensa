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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_controle_alimento")
    @SequenceGenerator(name = "seq_controle_alimento", sequenceName = "seq_controle_alimento")
    private Long id;

    @OneToOne
    @JoinColumn (name = "ID_ALIMENTO")
    private Alimento alimento;

    @OneToMany(mappedBy = "controleAlimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ControleAlimentoValidade> controlesAlimentoValidade;

    @Column(name = "QUANTIDADE_MINIMA")
    private Double quantidadeMinima;

    @Column (name = "QUANTIDADE_IDEAL")
    private Double quantidadeIdeal;

    @Column(name = "QUANTIDADE_ATUAL")
    private Double quantidadeAtual;


}

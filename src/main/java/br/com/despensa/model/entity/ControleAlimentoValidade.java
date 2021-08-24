package br.com.despensa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CONTROLE_ALIMENTOS_VALIDADE", schema = "DESPENSA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleAlimentoValidade {

    @Id
    @Column (name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_controle_alimento_validade")
    @SequenceGenerator(name = "seq_controle_alimento_validade", sequenceName = "seq_controle_alimento_validade")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CONTROLE_ALIMENTOS") // coloca aqui tambem?
    private ControleAlimento controleAlimento;

    @Column (name = "DATA_DE_VALIDADE")
    private String dataValidade;

}

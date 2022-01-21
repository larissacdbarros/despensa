package br.com.despensa.model.entity;

import br.com.despensa.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CONTROLE_ALIMENTO_VALIDADE", schema = Constants.SCHEMA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControleAlimentoValidade {

    @Id
    @Column (name = "ID_CONTROLE_ALIMENTO_VALIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CONTROLE_ALIMENTO") // coloca aqui tambem?
    private ControleAlimento controleAlimento;

    @Column (name = "DT_VALIDADE")
    private String dataValidade;

}

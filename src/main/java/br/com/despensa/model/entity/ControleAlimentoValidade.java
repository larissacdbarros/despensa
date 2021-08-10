package br.com.despensa.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CONTROLE_ALIMENTOS_VALIDADE", schema = "DESPENSA")
public class ControleAlimentoValidade {

    @Id
    @Column (name = "ID")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CONTROLE_ALIMENTOS") // coloca aqui tambem?
    public ControleAlimento controleAlimento;

    @Column (name = "DATA_DE_VALIDADE")
    private String dataValidade;

}

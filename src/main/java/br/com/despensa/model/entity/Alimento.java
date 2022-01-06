package br.com.despensa.model.entity;


import br.com.despensa.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_ALIMENTO", schema = Constants.SCHEMA)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alimento")
    private Long id;

    @OneToOne(mappedBy = "alimento")
    private ControleAlimento controleAlimento;

    @Column(name = "DS_NOME")
    private String nome;

    @Column(name = "QTD_GRAMATURA")
    private Double gramatura;


}

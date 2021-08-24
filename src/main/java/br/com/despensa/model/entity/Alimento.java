package br.com.despensa.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_ALIMENTOS", schema = "DESPENSA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alimento")
    @SequenceGenerator(name = "seq_alimento", sequenceName = "seq_alimento")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "GRAMATURA")
    private Double gramatura;

}

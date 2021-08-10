package br.com.despensa.model.entity;


import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ALIMENTOS", schema = "DESPENSA")
public class Alimento {
    @Id
    @Column (name = "ID")
    public Long id;

    @Column (name = "NOME")
    private String nome;

    @Column (name = "GRAMATURA")
    private Double gramatura;

}

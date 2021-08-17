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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getGramatura() {
        return gramatura;
    }

    public void setGramatura(Double gramatura) {
        this.gramatura = gramatura;
    }
}

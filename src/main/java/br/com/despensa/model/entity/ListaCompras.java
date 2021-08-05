package br.com.despensa.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ListaCompras {

    @Id
    public Long id;

    @ManyToMany
    public Lista lista;

    @ManyToMany
    public Alimento alimento;

}
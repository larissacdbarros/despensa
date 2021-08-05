package br.com.despensa.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Lista {

    @Id
    public Long id;

}

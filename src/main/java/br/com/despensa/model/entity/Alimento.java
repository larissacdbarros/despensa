package br.com.despensa.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alimento {

    @Id
    public Long id;
}

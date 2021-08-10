package br.com.despensa.repository;

import br.com.despensa.model.entity.ListaCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

public interface ListaComprasRepository extends JpaRepository<ListaCompras, Long> {
}

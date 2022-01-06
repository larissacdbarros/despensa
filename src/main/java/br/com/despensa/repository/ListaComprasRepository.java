package br.com.despensa.repository;

import br.com.despensa.model.entity.ListaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaComprasRepository extends JpaRepository<ListaCompra, Long> {
}

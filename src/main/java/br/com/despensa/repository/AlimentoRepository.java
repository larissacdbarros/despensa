package br.com.despensa.repository;

import br.com.despensa.model.entity.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository <Alimento, Long> {
}

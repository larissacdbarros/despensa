package br.com.despensa.repository;

import br.com.despensa.model.entity.ControleAlimentoValidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControleAlimentoValidadeRepository extends JpaRepository<ControleAlimentoValidade, Long> {
}

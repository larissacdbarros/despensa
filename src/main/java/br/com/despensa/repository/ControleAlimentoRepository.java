package br.com.despensa.repository;

import br.com.despensa.model.entity.ControleAlimento;
import org.apache.el.parser.JJTELParserState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleAlimentoRepository extends JpaRepository<ControleAlimento, Long> {
}

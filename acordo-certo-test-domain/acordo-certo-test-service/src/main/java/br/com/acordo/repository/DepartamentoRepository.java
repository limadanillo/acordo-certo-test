package br.com.acordo.repository;


import br.com.acordo.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	List<Departamento> findAllByDescricao(String description);
}

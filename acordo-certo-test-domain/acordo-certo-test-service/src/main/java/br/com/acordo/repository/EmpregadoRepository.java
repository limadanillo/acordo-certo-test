package br.com.acordo.repository;


import br.com.acordo.domain.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Integer> {
	Empregado findByNome(String nome);
}

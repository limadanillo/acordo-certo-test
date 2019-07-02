package br.com.acordo.service;

import br.com.acordo.domain.Departamento;
import java.util.List;

public interface DepartamentoService {

	public Departamento save(Departamento departamento);

	public Departamento update(Departamento departamento);

	public List<Departamento> findAll();

	public Departamento findOne(Integer id);

	public void delete(Integer id);
}

package br.com.acordo.service;

import br.com.acordo.domain.Empregado;
import java.util.List;

public interface EmpregadoService {

	public Empregado save(Empregado empregado);

	public Empregado update(Empregado empregado);

	public List<Empregado> findAll();

	public Empregado findOne(Integer id);

	public void delete(Integer id);
}

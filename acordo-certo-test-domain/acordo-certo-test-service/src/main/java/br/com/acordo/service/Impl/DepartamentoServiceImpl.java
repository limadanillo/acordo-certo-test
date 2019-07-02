package br.com.acordo.service.Impl;

import br.com.acordo.domain.Departamento;
import br.com.acordo.repository.DepartamentoRepository;
import br.com.acordo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	private DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public Departamento save(Departamento departamento) {
		if (departamento.getId() != null && departamentoRepository.exists(departamento.getId())) {
			throw new EntityExistsException("Já existe departamento com esse ID no banco de dados.");
		}

		return departamentoRepository.save(departamento);
	}

	@Override
	public Departamento update(Departamento departamento) {
		if (departamento.getId() != null && !departamentoRepository.exists(departamento.getId())) {
			throw new EntityNotFoundException("Não existe nenhum departamento com esse ID no banco de dados.");
		}

		return departamentoRepository.save(departamento);
	}

	@Override
	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}

	@Override
	public Departamento findOne(Integer id) {
		return departamentoRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		departamentoRepository.delete(id);
	}
}

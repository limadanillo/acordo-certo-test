package br.com.acordo.service.Impl;

import br.com.acordo.domain.Empregado;
import br.com.acordo.repository.EmpregadoRepository;
import br.com.acordo.service.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmpregadoServiceImpl implements EmpregadoService {
	private EmpregadoRepository empregadoRepository;

	@Autowired
	public EmpregadoServiceImpl(EmpregadoRepository empregadoRepository) {
		this.empregadoRepository = empregadoRepository;
	}

	@Override
	public Empregado save(Empregado empregado) {
		if (empregado.getId() != null && empregadoRepository.exists(empregado.getId())) {
			throw new EntityExistsException("Já existe empregado com esse ID no banco de dados.");
		}

		return empregadoRepository.save(empregado);
	}

	@Override
	public Empregado update(Empregado empregado) {
		if (empregado.getId() != null && !empregadoRepository.exists(empregado.getId())) {
			throw new EntityNotFoundException("Não existe nenhum empregado com esse ID no banco de dados.");
		}

		return empregadoRepository.save(empregado);
	}

	@Override
	public List<Empregado> findAll() {
		return empregadoRepository.findAll();
	}

	@Override
	public Empregado findOne(Integer id) {
		return empregadoRepository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		empregadoRepository.delete(id);
	}
}

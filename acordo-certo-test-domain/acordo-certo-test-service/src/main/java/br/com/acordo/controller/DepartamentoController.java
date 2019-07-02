package br.com.acordo.controller;

import br.com.acordo.domain.Departamento;
import br.com.acordo.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartamentoController {
	private DepartamentoService departamentoService;

	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@RequestMapping(value = "departamento", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Departamento> getAllDepartments() {
		return departamentoService.findAll();
	}

	@RequestMapping(value = "departamento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> createDepartment(@RequestBody Departamento departamento) throws URISyntaxException {
		Departamento result = departamentoService.save(departamento);

		return ResponseEntity.created(new URI("/api/departamento/" + result.getId())).body(result);
	}

	@RequestMapping(value = "departamento", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> updateDepartment(@RequestBody Departamento departamento) throws URISyntaxException {
		if (departamento.getId() == null) {
			return new ResponseEntity<Departamento>(HttpStatus.NOT_FOUND);
		}

		try {
			Departamento result = departamentoService.update(departamento);

			return ResponseEntity.created(new URI("/api/departamento/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Departamento>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/departamento/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteDepartment(@PathVariable Integer id) {
		departamentoService.delete(id);

		return ResponseEntity.ok().build();
	}
}

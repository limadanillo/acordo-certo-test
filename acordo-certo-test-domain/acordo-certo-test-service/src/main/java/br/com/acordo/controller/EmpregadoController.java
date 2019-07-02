package br.com.acordo.controller;

import br.com.acordo.domain.Empregado;
import br.com.acordo.service.EmpregadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpregadoController {

	private EmpregadoService empregadoService;

	public EmpregadoController(EmpregadoService empregadoService) {
		this.empregadoService = empregadoService;
	}

	@RequestMapping(value = "empregado", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Empregado> getAllEmpregados() {
		return empregadoService.findAll();
	}

	@RequestMapping(value = "empregado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empregado> createEmpregado(@RequestBody Empregado empregado) throws URISyntaxException {
		try {
			Empregado result = empregadoService.save(empregado);
			return ResponseEntity.created(new URI("/api/empregado/" + result.getId())).body(result);
		} catch (EntityExistsException e) {
			return new ResponseEntity<Empregado>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "empregado", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empregado> updateEmpregado(@RequestBody Empregado empregado) throws URISyntaxException {
		if (empregado.getId() == null) {
			return new ResponseEntity<Empregado>(HttpStatus.NOT_FOUND);
		}

		try {
			Empregado result = empregadoService.update(empregado);

			return ResponseEntity.created(new URI("/api/empregado/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<Empregado>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/empregado/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteEmpregado(@PathVariable Integer id) {
		empregadoService.delete(id);

		return ResponseEntity.ok().build();
	}
}

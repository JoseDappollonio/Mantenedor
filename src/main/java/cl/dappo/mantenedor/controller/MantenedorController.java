package cl.dappo.mantenedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.dappo.mantenedor.dto.MantenedorDTO;
import cl.dappo.mantenedor.entity.MantenedorEntity;
import cl.dappo.mantenedor.service.MantenedorService;
import cl.dappo.mantenedor.service.impl.MantenedorServiceImpl;

@RestController
@RequestMapping("/mantenedor")
public class MantenedorController {

	@Autowired
	MantenedorService services;

	// traer lista
	//
	@GetMapping()
	public List<MantenedorEntity> selectAll() {
		return services.selectAll();
	}

	// Agregar datos
	@PostMapping()
	public MantenedorDTO insert(@RequestBody MantenedorDTO entrada) {
		return services.insert(entrada);
	}
	
	
	@PutMapping
	public MantenedorDTO update(@RequestBody MantenedorDTO entrada) {
		return services.update(entrada);
	}
	
	
	@DeleteMapping
	public void delete(@RequestBody MantenedorDTO entrada) {
		services.delete(entrada);
	}

}

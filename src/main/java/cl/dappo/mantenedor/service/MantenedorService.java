package cl.dappo.mantenedor.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.dappo.mantenedor.dto.MantenedorDTO;
import cl.dappo.mantenedor.entity.MantenedorEntity;

public interface MantenedorService {
	
	List<MantenedorEntity> selectAll();

	MantenedorDTO insert(MantenedorDTO entrada);
	
	HashMap<String, String> delete (MantenedorDTO entrada);
	
	MantenedorDTO update (MantenedorDTO entrada);

}

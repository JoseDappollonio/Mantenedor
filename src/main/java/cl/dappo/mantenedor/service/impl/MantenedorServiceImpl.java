package cl.dappo.mantenedor.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.dappo.mantenedor.dto.MantenedorDTO;
import cl.dappo.mantenedor.entity.MantenedorEntity;
import cl.dappo.mantenedor.repository.MantenedorRepository;
import cl.dappo.mantenedor.service.MantenedorService;

@Service
public class MantenedorServiceImpl implements MantenedorService {
	
	@Autowired
	MantenedorRepository mantenedor;

	@Override
	public List<MantenedorEntity> selectAll() {
		List<MantenedorEntity> response = mantenedor.findAll();
		return response;
	}

	@Override
	public MantenedorDTO insert(MantenedorDTO entrada) {
		MantenedorEntity input = new MantenedorEntity();
		MantenedorDTO response = new MantenedorDTO();
		input.setDescripcion(entrada.getDescripcion());
		Date fecha = Date.valueOf(entrada.getFecha());
		input.setFecha(fecha);
		input.setVigente(entrada.getVigente());
		if(null != entrada) {
			MantenedorEntity saved = mantenedor.save(input);
			response.setDescripcion(saved.getDescripcion());
			response.setFecha(saved.getFecha().toLocalDate());
			response.setVigente(saved.getVigente());
			
		}
		return response;
	}

	@Override
	public HashMap<String, String> delete(MantenedorDTO entrada) {

		HashMap<String, String> respuesta = new HashMap<>();
		try {
			mantenedor.deleteById(entrada.getIdentificador());

		} catch (Exception e) {
			respuesta.put("mensaje", "Error al intentar borrar");
			return respuesta;
		}
		return respuesta;

	
	}

	@Override
	public MantenedorDTO update(MantenedorDTO entrada) {
		MantenedorEntity mantenedorFinded = null;
		MantenedorEntity mantenedorSaved = null;
		MantenedorDTO response = null;
		if(entrada.getIdentificador() != null) {
			mantenedorFinded = mantenedor.findById(entrada.getIdentificador()).orElseThrow(null);
		}
		if(null != mantenedorFinded) {
			mantenedorFinded.setDescripcion(entrada.getDescripcion());
			Date fecha = Date.valueOf(entrada.getFecha());
			mantenedorFinded.setFecha(fecha);
			mantenedorFinded.setVigente(entrada.getVigente());
			mantenedorSaved = mantenedor.save(mantenedorFinded);
		}
		if(null != mantenedorSaved) {
			response = new MantenedorDTO();
			response.setDescripcion(mantenedorSaved.getDescripcion());
			response.setFecha(mantenedorSaved.getFecha().toLocalDate());
			response.setVigente(mantenedorSaved.getVigente());
		}
		
		return response;
	}

}

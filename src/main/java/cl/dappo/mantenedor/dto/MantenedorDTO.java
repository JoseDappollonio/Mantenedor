package cl.dappo.mantenedor.dto;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MantenedorDTO {

	
	private Long identificador;
	
	private String descripcion;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fecha;

	private Boolean vigente;
	
	
}

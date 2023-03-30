package cl.dappo.mantenedor.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "mantenedor")
@Entity
public class MantenedorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identificador;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "fecha")
	@JsonFormat(pattern="dd-mm-yyyy")
	private Date fecha;
	
	@Column(name = "vigente")
	private Boolean vigente;

}

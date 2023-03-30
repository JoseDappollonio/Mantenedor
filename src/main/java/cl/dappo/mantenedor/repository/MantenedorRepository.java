package cl.dappo.mantenedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.dappo.mantenedor.entity.MantenedorEntity;

public interface MantenedorRepository extends JpaRepository<MantenedorEntity, Long>{

}

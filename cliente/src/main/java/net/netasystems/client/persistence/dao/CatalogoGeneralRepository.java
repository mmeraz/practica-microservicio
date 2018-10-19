package net.netasystems.client.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.netasystems.client.persistence.entities.CatalogoGeneral;

public interface CatalogoGeneralRepository extends
JpaRepository<CatalogoGeneral, Integer> {
	
		//List<CatalogoGeneral> findAllByIdCatalogo(Integer idEstatus);
		List<CatalogoGeneral> findAllByIdCatalogo(Integer idCatalogo);
	
}

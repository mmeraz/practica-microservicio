package net.netasystems.client.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import net.netasystems.client.persistence.entities.CatalogoGeneral;
import net.netasystems.client.persistence.entities.Cliente;

public interface ClienteDAO extends
JpaRepository<Cliente, Integer> {

List<Cliente> findAllByCatalogoGeneralIdCatalogo(Integer idEstatus);

List<Cliente> findAllByEmailCliente(String email);

List<Cliente> findAllByCelCliente(String cel);

Cliente findClienteByCelClienteAndEmailClienteAndCatalogoGeneralIdCatalogo(String cel,
                                                                       String email,
                                                                       Integer idEstatus);

}
package br.edu.infnet.applanche.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.applanche.model.domain.Solicitante;

@Repository
public interface SolicitanteRepository extends CrudRepository<Solicitante, Integer> {

	@Query("from Solicitante s where s.usuario.id = :userId")
	List<Solicitante> obterLista(Integer userId);
}
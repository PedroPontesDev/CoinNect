package com.coinnect.CoinNect.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coinnect.CoinNect.model.entities.Contratante;

public interface ContratanteRepositories extends JpaRepository<Contratante, Long> {

	@Query("SELECT c FROM Contratante c JOIN c.usuario u WHERE u.endereco.rua = :rua AND u.endereco.numero = :numero")
	Contratante findByEndereco(@Param("rua") String rua, @Param("numero") Integer numero);
	
}

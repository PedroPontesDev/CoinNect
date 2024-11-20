package com.coinnect.CoinNect.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coinnect.CoinNect.model.entities.Contrato;

public interface ContratoRepositories extends JpaRepository<Contrato, Long> {
	
	@Query("SELECT c FROM Contrato c WHERE c.dataInicio BETWEEN :inicio AND :termino"
			+ "AND c.dataTermino BETWEEN :inicio AND :termino")
	Set<Contrato> findByDataInicioAndDataTermino(LocalDate inicio, LocalDate termino);
	
	
	Set<Contrato> findByValorMaximo(@Param("valor") BigDecimal valor);
}

package com.coinnect.CoinNect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coinnect.CoinNect.model.entities.Contrato;

public interface ContratoRepositories extends JpaRepository<Contrato, Long> {
	
}

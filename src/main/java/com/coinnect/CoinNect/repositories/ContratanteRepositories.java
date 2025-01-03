package com.coinnect.CoinNect.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coinnect.CoinNect.model.entities.Contratante;

public interface ContratanteRepositories extends JpaRepository<Contratante, Long> {

	
}

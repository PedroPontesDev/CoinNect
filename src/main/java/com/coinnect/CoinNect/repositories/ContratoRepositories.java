package com.coinnect.CoinNect.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coinnect.CoinNect.model.entities.Contrato;
import com.coinnect.CoinNect.model.enums.StatusContrato;

public interface ContratoRepositories extends JpaRepository<Contrato, Long> {
    
	@Query("SELECT COUNT(c) > 0 FROM Contrato c WHERE c.contratante.id = :contratanteId AND c.prestador.id = :prestadorId")
	boolean verificarContratoExiste(@Param("contratanteId") Long contratanteId, 
									@Param("prestadorId") Long prestadorId);
	
    @Query("SELECT c FROM Contrato c WHERE c.status = :status")
    List<Contrato> findByStatus(@Param("status") StatusContrato status);
    
    @Query("SELECT c FROM Contrato c WHERE c.dataInicio BETWEEN :inicio AND :termino "
         + "AND c.dataTermino BETWEEN :inicio AND :termino")
    Set<Contrato> findByDataInicioAndDataTermino(@Param("inicio") LocalDate inicio, 
                                                 @Param("termino") LocalDate termino);
    
    @Query("SELECT c FROM Contrato c WHERE c.valor >= :valorMinimo ORDER BY c.valor DESC")
    Set<Contrato> findByValorMaximo(@Param("valorMinimo") BigDecimal valorMinimo);


}

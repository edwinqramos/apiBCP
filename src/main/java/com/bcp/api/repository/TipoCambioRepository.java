package com.bcp.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bcp.api.entity.TipoCambio;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {
	
	@Query("SELECT t FROM TipoCambio t WHERE t.fecha = CURRENT_DATE()")	
	//@Query(nativeQuery = true, value = "SELECT top 1 id,fecha,moneda_origen,moneda_destino,factor FROM tbl_tipocambio t WHERE t.fecha = CURRENT_DATE() and t.moneda_origen = :monedaOrigen and t.moneda_destino = :monedaDestino")
	public TipoCambio obtenerCambioDia(@Param("monedaOrigen") String monedaOrigen, @Param("monedaDestino") String monedaDestino);

}

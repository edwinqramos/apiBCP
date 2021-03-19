package com.bcp.api.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_tipocambio")
@Data
@AllArgsConstructor @NoArgsConstructor
public class TipoCambio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name = "moneda_origen")
	private String monedaOrigen;
    @Column(name = "moneda_destino")
	private String monedaDestino;
	private Double factor;
    private Date fecha;
	
}

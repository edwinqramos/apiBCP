package com.bcp.api.dto;

import java.io.Serializable;

public class TipoCambioResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Double monto;
	private Double montoCambio;
	private String monedaOrigen;
	private String monedaDestino;
	private Double tipoCambio;
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getMontoCambio() {
		return montoCambio;
	}
	public void setMontoCambio(Double montoCambio) {
		this.montoCambio = montoCambio;
	}
	public String getMonedaOrigen() {
		return monedaOrigen;
	}
	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}
	public String getMonedaDestino() {
		return monedaDestino;
	}
	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	
	

}

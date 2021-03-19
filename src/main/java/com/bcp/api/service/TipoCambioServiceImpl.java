package com.bcp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.api.dto.TipoCambioRequestDTO;
import com.bcp.api.entity.TipoCambio;
import com.bcp.api.repository.TipoCambioRepository;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;

	@Override
	public TipoCambio getTipoCambioDia(TipoCambioRequestDTO tipoCambioRequestDTO) {
		//return tipoCambioRepository.findById(1L).orElse(null);
		return tipoCambioRepository.obtenerCambioDia(tipoCambioRequestDTO.getMonedaOrigen(), tipoCambioRequestDTO.getMonedaDestino());
	}

}

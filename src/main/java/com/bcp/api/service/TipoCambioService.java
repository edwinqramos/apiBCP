package com.bcp.api.service;

import org.springframework.stereotype.Service;

import com.bcp.api.dto.TipoCambioRequestDTO;
import com.bcp.api.entity.TipoCambio;

@Service
public interface TipoCambioService {
	
	public TipoCambio getTipoCambioDia(TipoCambioRequestDTO tipoCambioRequestDTO);

}

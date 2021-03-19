package com.bcp.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcp.api.dto.TipoCambioRequestDTO;
import com.bcp.api.dto.TipoCambioResponseDTO;
import com.bcp.api.entity.TipoCambio;
import com.bcp.api.service.TipoCambioService;

import io.reactivex.Observable;

@RestController
@RequestMapping(value = { "/api/v1" })
public class TipoCambioController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioController.class);
	
	@Autowired
	private TipoCambioService tipoCambioService;

	@GetMapping(value = "/tipoCambio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCambioResponseDTO> consultar(@RequestBody TipoCambioRequestDTO tipoCambioRequestDTO) {
		try {

			TipoCambioResponseDTO result = this.obtenerTipoCambio(tipoCambioRequestDTO);
		
			return new ResponseEntity<TipoCambioResponseDTO>(result, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/tipoCambioReactivo", produces = MediaType.APPLICATION_JSON_VALUE)
	public Observable<TipoCambioResponseDTO> consultar2(@RequestBody TipoCambioRequestDTO tipoCambioRequestDTO) {
		TipoCambioResponseDTO result = this.obtenerTipoCambio(tipoCambioRequestDTO);
			
		return Observable.just(result);
	}
	

	private TipoCambioResponseDTO obtenerTipoCambio(TipoCambioRequestDTO tipoCambioRequestDTO) {
		
		TipoCambio tipoCambioDia = tipoCambioService.getTipoCambioDia(tipoCambioRequestDTO);
		
		TipoCambioResponseDTO result = new TipoCambioResponseDTO();
		result.setMonto(tipoCambioRequestDTO.getMonto());
		result.setMonedaOrigen(tipoCambioDia.getMonedaOrigen());
		result.setMonedaDestino(tipoCambioDia.getMonedaDestino());
		result.setTipoCambio(tipoCambioDia.getFactor());
		result.setMontoCambio(result.getMonto() * result.getTipoCambio());

		return result;
	}

}

package com.his.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.his.dto.EligDetermineDTO;

@FeignClient(name="ED-API")
public interface EdApiClient {
	@GetMapping("/eddetails/{appNumber}")
	public EligDetermineDTO getEdDetalilByAppNumber(@PathVariable("appNumber") Integer appNumber);
	@GetMapping("/eddetails")
	public List<EligDetermineDTO> getAllEdDetalil();
	
	
}

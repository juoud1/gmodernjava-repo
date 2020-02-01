package com.dobatii.gworkummymodernjava.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dobatii.gworkummymodernjava.ws.model.Province;
import com.dobatii.gworkummymodernjava.ws.service.ProvinceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProvinceController {
	
	private final ProvinceService provinceService;
	
	@Autowired
	public ProvinceController(ProvinceService provinceService) {
		super();
		this.provinceService = provinceService;
		
		log.info("province controller ready!".toUpperCase());
	}
	
	@GetMapping("provinces")
	public List<Province> getProvinces(){
		return provinceService.getProvinces();
	}
}

package com.dobatii.gworkummymodernjava.ws.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dobatii.gworkummymodernjava.ws.model.Province;

public interface ProvinceService {
	
	List<Province> getProvinces(Pageable pageable);
	List<Province> getProvinces(Sort sort);
	List<Province> getProvinces();
	
}

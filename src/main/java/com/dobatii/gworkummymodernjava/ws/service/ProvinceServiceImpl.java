package com.dobatii.gworkummymodernjava.ws.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dobatii.gworkummymodernjava.ws.model.Province;
import com.dobatii.gworkummymodernjava.ws.repository.jpa.ProvinceRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
	
	private final ProvinceRepository provinceRepository;
	
	@Autowired
	public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
		this.provinceRepository = provinceRepository;
		
		log.info("province repository ready!".toUpperCase());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Province> getProvinces(Pageable pageable) {
		return (List<Province>) provinceRepository.findAll(pageable);
	}

	@Override
	public List<Province> getProvinces(Sort sort) {
		return (List<Province>) provinceRepository.findAll(sort);
	}

	@Override
	public List<Province> getProvinces() {
		return new ArrayList<Province>((Collection<Province>) provinceRepository.findAll());
	}

}

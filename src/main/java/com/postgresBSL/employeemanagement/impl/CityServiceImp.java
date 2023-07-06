package com.postgresBSL.employeemanagement.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresBSL.employeemanagement.entity.City;
import com.postgresBSL.employeemanagement.entity.Country;
import com.postgresBSL.employeemanagement.pojos.CityRequest;
import com.postgresBSL.employeemanagement.repository.CityRepository;
import com.postgresBSL.employeemanagement.repository.CountryRepository;
import com.postgresBSL.employeemanagement.service.CityService;

@Service
public class CityServiceImp implements CityService{

	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	CountryRepository countryRepo;
	
	@Override
	public List<City> getCities() {
		// TODO Auto-generated method stub
		return cityRepo.findAll();
	}

	@Override
	public City getCityByName(String cityname) {
		// TODO Auto-generated method stub
		System.out.println(cityname);
		return cityRepo.findByCityname(cityname);
	}

	@Override
	public City addCities(City city) {
		// TODO Auto-generated method stub
		return cityRepo.save(city);
	}

	@Override
	public City saveCity(CityRequest cityReq) {
		// TODO Auto-generated method stub
		System.out.println(cityReq);
		Country country = countryRepo.findById(cityReq.country_id);
		City city =new City();
		System.out.println("code");
		city.setCityname(cityReq.cityname);
		city.setCityCode(cityReq.citycode);
		city.setCountry(country);
		return cityRepo.save(city);
	}

}

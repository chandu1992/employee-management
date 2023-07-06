package com.postgresBSL.employeemanagement.service;

import java.util.List;

import com.postgresBSL.employeemanagement.entity.City;
import com.postgresBSL.employeemanagement.pojos.CityRequest;

public interface CityService {

	 List<City> getCities();
	 
	 City addCities(City city);

	City getCityByName(String cityName);

	City saveCity(CityRequest cityReq);

}

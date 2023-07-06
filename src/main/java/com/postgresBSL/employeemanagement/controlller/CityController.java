package com.postgresBSL.employeemanagement.controlller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.postgresBSL.employeemanagement.entity.City;
import com.postgresBSL.employeemanagement.pojos.CityRequest;
import com.postgresBSL.employeemanagement.service.CityService;

@RestController
public class CityController {

	@Autowired
	CityService cityService;
	
	@GetMapping("/getCities")
	public List<City> findAllCIty(){
		return cityService.getCities();
	}
	
	@PostMapping("/addCity")
	public City addCity(@RequestBody City city){
		return cityService.addCities(city);
	}
	
	@GetMapping("/getCity")
	public City addCity(@RequestHeader String cityname){
		return cityService.getCityByName(cityname);
	}
	
	@PostMapping("/saveCity")
	public City saveCity(@RequestBody CityRequest cityReq) {
		return cityService.saveCity(cityReq);
	}
}

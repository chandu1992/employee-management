package com.postgresBSL.employeemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresBSL.employeemanagement.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	City findByCityname(String cityname);

}

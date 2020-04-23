package com.thornBird.sbd.modules.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.thornBird.sbd.modules.common.Result;
import com.thornBird.sbd.modules.test.entity.City;
import com.thornBird.sbd.modules.test.service.CityService;

@RestController
@RequestMapping("/api")
public class CityController {
	@Autowired
	private CityService cityservice;
	/*
	 * http://localhost/api/getCities/{countryId}
	 */
	@RequestMapping("/getCities/{countryId}")
	public List<City> getCitiesByCountryId(@PathVariable int countryId){
		return cityservice.getCitiesByCountryId(countryId);
	}
	
	/*
	 * http://localhost/api/getCitiesByPage?currentPage=1&pageSize=10&countryId=522
	 */
	@RequestMapping("/getCitiesByPage")
	public PageInfo<City> getCitiesByPage(@RequestParam int currentPage,@RequestParam int pageSize,@RequestParam int countryId){
		return cityservice.getCitiesByPage(currentPage, pageSize, countryId);
	}
	
	/*
	 * http://localhost/api/city
	 * consumes="application/json"进入接口的一种格式，当他为json时，参数用@RequestBody接收
	 */
	@PostMapping(value="/city",consumes="application/json")
	public Result<City> insertCity(@RequestBody City city){
		return cityservice.insertCity(city);
	}
}

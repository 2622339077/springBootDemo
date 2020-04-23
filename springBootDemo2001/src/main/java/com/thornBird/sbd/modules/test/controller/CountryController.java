package com.thornBird.sbd.modules.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thornBird.sbd.modules.test.entity.Country;
import com.thornBird.sbd.modules.test.service.CountryService;

@RestController
@RequestMapping("/api")
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	/*
	 * http://localhost/api/getCountryByCountryId/{countryId}
	 * @PathVariable:参数为int类型的时候引用
	 */
	@RequestMapping("/getCountryByCountryId/{countryId}")
	public Country getCountryByCountryId(@PathVariable int countryId){
		Country country = countryService.selectCountryByCountryId(countryId);
		return country;
	}
	

	/*
	 * http://localhost/api/getCountryByCountryName?countryName=China
	 * @RequestParam:参数为string类型的时候引用
	 */
	@RequestMapping("/getCountryByCountryName")
	public Country getCountryByCountryName(@RequestParam String countryName){
		Country country = countryService.selectCountryByCountryName(countryName);
		return country;
	}
}

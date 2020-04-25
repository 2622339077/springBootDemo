package com.thornBird.sbd.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.thornBird.sbd.modules.common.Result;
import com.thornBird.sbd.modules.common.Result.ResultEnum;
import com.thornBird.sbd.modules.test.dao.CityDao;
import com.thornBird.sbd.modules.test.entity.City;
import com.thornBird.sbd.modules.test.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao citydao;

	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		List<City> cities = citydao.getCitiesByCountryId(countryId);
		return cities;
	}

	@Override
	public City getCityByCityNameAndLocalCityName(String cityName, String localCityName) {
		return citydao.getCityByCityNameAndLocalCityName1(cityName,localCityName);
	}

	/*
	 * 分页查询
	 */
	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize, int countryId) {
		PageHelper.startPage(currentPage, pageSize);
		List<City> cities = citydao.getCitiesByCountryId(countryId);
		return new PageInfo<City>(cities);
	}

	@Override
	public Result<City> insertCity(City city) {
		Result<City> result = new Result<City>(ResultEnum.SUCCESS.status, "Insert success");
		try {
			citydao.insertCity(city);
			result.setObject(city);
		} catch (Exception e) {
			result.setStatus(ResultEnum.FAILD.status);
			result.setMessage(e.getMessage());
		}
		return result;
	}

	/*
	 * 	@Transactional:事务
	 */
	@Override
	@Transactional
	public Result<City> updateCityByCityId(City city) {
		Result<City> result = new Result<City>(ResultEnum.SUCCESS.status, "updateCity success");
	
			citydao.updateCityByCityId(city);
			result.setObject(city);
//			int a = 1/0;
		return result;
	}

	@Override
	public Result<Object> DeleteCityByCityId(int cityId) {
		Result<Object> result = new Result<Object>(ResultEnum.SUCCESS.status, "deleteCity success");
		try {
			citydao.deleteCityByCityId(cityId);
		} catch (Exception e) {
			result.setMessage(e.getMessage());
			result.setStatus(result.getStatus());
		}
		return result;
	}

}

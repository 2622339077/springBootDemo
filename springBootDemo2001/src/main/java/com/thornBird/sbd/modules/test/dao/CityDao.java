package com.thornBird.sbd.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.thornBird.sbd.modules.common.Result;
import com.thornBird.sbd.modules.test.entity.City;

@Mapper
public interface CityDao {
	/*
	 * #{conutryId} 
	 * ${countryId}
	 */
	@Select("select * from m_city where country_id = #{conutryId}")
	List<City> getCitiesByCountryId(int countryId);
	
	@Insert("insert into m_city(city_name,local_city_name,country_id,date_created) values(#{cityName},#{localCityName},#{countryId},#{dateCreated})")
	@Options(useGeneratedKeys=true,keyColumn="city_id",keyProperty="cityId")
	Result<City> insertCity(City city);

	
	
}

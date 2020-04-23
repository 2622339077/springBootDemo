package com.thornBird.sbd.modules.test.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.thornBird.sbd.modules.test.entity.Country;

@Mapper
public interface CountryDao {
	
	@Select("select * from m_country where country_id=#{countryId}")
	@Results({
		@Result(column="country_id",property="countryId"),
		@Result(column="country_id",property="cities",
			many=@Many(select="com.thornBird.sbd.modules.test.dao.CityDao.getCitiesByCountryId"))
			})
	public Country selectCountryByCountryId(int countryId);

	@Select("select * from m_country where country_name=#{countryName}")
	@Results({
		@Result(column="country_id",property="countryId"),
		@Result(column="country_id",property="cities",
			many=@Many(select="com.thornBird.sbd.modules.test.dao.CityDao.getCitiesByCountryId"))
			})
	public Country selectCountryByCountryName(String countryName);

}

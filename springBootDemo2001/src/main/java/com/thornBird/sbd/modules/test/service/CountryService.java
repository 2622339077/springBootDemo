package com.thornBird.sbd.modules.test.service;

import com.thornBird.sbd.modules.test.entity.Country;

public interface CountryService {

	Country selectCountryByCountryId(int countryId);

	Country selectCountryByCountryName(String countryName);

}

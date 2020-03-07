package com.qzh.epidemic.service;

import com.qzh.epidemic.entity.CountryStat;

import java.util.List;

public interface CountryStatService {
    void addCountryStatList(List<CountryStat> countryStats);

    List<CountryStat> getCountryStatsByContinents(String continents);
}

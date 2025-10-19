package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.entity.Country;
import com.bogazici.athleticsresult.mapper.CountryMapper;
import com.bogazici.athleticsresult.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public Country getCountryByCountryCode(String countryCode) {
        Optional<Country> country = countryRepository.findByCountryCode(countryCode);
        if (country.isPresent()) {
            return country.get();
        } else {
            throw new RuntimeException("Country not found");
        }
    }
}
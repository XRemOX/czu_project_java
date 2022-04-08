package com.czu.project.service;

import com.czu.project.entity.City;
import com.czu.project.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService implements ServiceInt<City> {
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City findById(int id) {
        return cityRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);
    }
}

package com.czu.project.restcontroller;

import com.czu.project.entity.City;
import com.czu.project.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/city")
public class CityRESTController {
    private CityService cityService;

    @GetMapping
    List<City> allCities() {
        return cityService.findAll();
    }

    @PostMapping
    void newCity(@RequestBody City city) {
        cityService.save(city);
    }

    @GetMapping("/{id}")
    City getCityById(@PathVariable int id) {
        return cityService.findById(id);
    }

    @PutMapping
    City updateCity(@RequestBody City city) {
        cityService.save(city);
        return city;
    }

    @DeleteMapping("/{id}")
    void deleteCity(@PathVariable int id) {
        cityService.deleteById(id);
    }
}

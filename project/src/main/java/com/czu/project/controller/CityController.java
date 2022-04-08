package com.czu.project.controller;

import com.czu.project.entity.City;
import com.czu.project.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/city")
public class CityController {
    private CityService cityService;

    @GetMapping("/")
    public String index(Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "/city/cityIndex";
    }

    @GetMapping("/addNew")
    public String addNewCity(Model model) {
        City city = new City();
        model.addAttribute("city", city);
        return "/city/newCity";
    }

    @PostMapping("/save")
    public String saveCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "/city/updateCity";
    }

    @GetMapping("/delete/{id}")
    public String deleteCity(@PathVariable(value = "id") int id) {
        cityService.deleteById(id);
        return "redirect:/";
    }
}

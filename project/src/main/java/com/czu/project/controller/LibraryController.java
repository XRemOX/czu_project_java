package com.czu.project.controller;

import com.czu.project.entity.Book;
import com.czu.project.entity.City;
import com.czu.project.entity.Library;
import com.czu.project.service.BookService;
import com.czu.project.service.CityService;
import com.czu.project.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/library")
public class LibraryController {
    private LibraryService libraryService;
    private CityService cityService;
    private BookService bookService;

    @GetMapping("/")
    public String index(Model model) {
        List<Library> libraries = libraryService.findAll();
        model.addAttribute("libraries", libraries);
        return "/library/libraryIndex";
    }

    @GetMapping("/addNew")
    public String addNewLibrary(Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        Library library = new Library();
        model.addAttribute("library", library);
        return "/library/newLibrary";
    }

    @PostMapping("/save")
    public String saveLibrary(@ModelAttribute("library") Library library) {
        libraryService.save(library);
        return "redirect:/library/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        Library library = libraryService.findById(id);
        model.addAttribute("library", library);
        return "/library/updateLibrary";
    }

    @GetMapping("/delete/{id}")
    public String deleteLibrary(@PathVariable(value = "id") int id) {
        libraryService.deleteById(id);
        return "redirect:/library/";
    }
}

package com.czu.project.restcontroller;

import com.czu.project.entity.Library;
import com.czu.project.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/library")
public class LibraryRESTController {
    private LibraryService libraryService;

    @GetMapping
    List<Library> allLibraries() {
        return libraryService.findAll();
    }

    @PostMapping
    void newLibrary(@RequestBody Library library) {
        libraryService.save(library);
    }

    @GetMapping("/{id}")
    Library getLibraryById(@PathVariable int id) {
        return libraryService.findById(id);
    }

    @PutMapping
    Library updateLibrary(@RequestBody Library library) {
        libraryService.save(library);
        return library;
    }

    @DeleteMapping("/{id}")
    void deleteLibrary(@PathVariable int id) {
        libraryService.deleteById(id);
    }
}
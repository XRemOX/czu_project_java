package com.czu.project.service;

import com.czu.project.entity.Library;
import com.czu.project.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryService implements ServiceInt<Library> {
    private LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public void save(Library library) {
        libraryRepository.save(library);
    }

    @Override
    public Library findById(int id) {
        return libraryRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        libraryRepository.deleteById(id);
    }
}

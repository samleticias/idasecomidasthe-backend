package com.ifpi.idasecomidasthe.service;

import com.ifpi.idasecomidasthe.dto.store.StoreDTO;
import com.ifpi.idasecomidasthe.model.Category;
import com.ifpi.idasecomidasthe.model.Store;
import com.ifpi.idasecomidasthe.repository.CategoryRepository;
import com.ifpi.idasecomidasthe.repository.StoreRepository;
import com.ifpi.idasecomidasthe.service.exception.category.CategoryNotFoundException;
import com.ifpi.idasecomidasthe.service.exception.store.StoreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;

    public List<Store> listAll() {
        return storeRepository.findAll();
    }

    public Store findById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException("Loja não encontrada"));
    }

    public Store create(StoreDTO dto) {

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));

        Store store = new Store();
        store.setName(dto.name());
        store.setDescription(dto.description());
        store.setOpeningHours(dto.openingHours());
        store.setLatitude(dto.latitude());
        store.setLongitude(dto.longitude());
        store.setCategory(category);

        return storeRepository.save(store);
    }

    public Store update(Long id, StoreDTO dto) {
        Store store = findById(id);

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));

        store.setName(dto.name());
        store.setDescription(dto.description());
        store.setOpeningHours(dto.openingHours());
        store.setLatitude(dto.latitude());
        store.setLongitude(dto.longitude());
        store.setCategory(category);

        return storeRepository.save(store);
    }

    public void delete(Long id) {
        Store store = findById(id);
        storeRepository.delete(store);
    }
}

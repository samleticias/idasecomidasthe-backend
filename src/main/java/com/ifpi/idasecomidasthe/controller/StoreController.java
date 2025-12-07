package com.ifpi.idasecomidasthe.controller;

import com.ifpi.idasecomidasthe.dto.store.StoreDTO;
import com.ifpi.idasecomidasthe.model.Store;
import com.ifpi.idasecomidasthe.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public List<Store> listAll() {
        return storeService.listAll();
    }

    @GetMapping("/{id}")
    public Store getById(@PathVariable Long id) {
        return storeService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody StoreDTO dto) {
        Store store = storeService.create(dto);
        return ResponseEntity.status(201).body(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Store> update(@PathVariable Long id, @RequestBody StoreDTO dto) {
        Store updated = storeService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        storeService.delete(id);
        return ResponseEntity.ok("Loja removida");
    }
}

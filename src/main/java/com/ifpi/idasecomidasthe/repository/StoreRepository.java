package com.ifpi.idasecomidasthe.repository;

import com.ifpi.idasecomidasthe.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}

package com.example.MaryCatqapi.repository;


import com.example.MaryCatqapi.entity.Parish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParishRepository extends JpaRepository<Parish,Long> {

    @Query(value = "SELECT * FROM parishes WHERE name LIKE %?1% OR CNPJ LIKE ?2%", nativeQuery = true)
    Page<Parish> findByName(String name, String cnpj, Pageable pageable);

}

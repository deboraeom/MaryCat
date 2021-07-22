package com.example.MaryCatqapi.repository;

import com.example.MaryCatqapi.entity.Church;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface churchesRepository extends JpaRepository<Church,Long> {

    Church findByEmail(String email);

    @Query(value = "SELECT * FROM churches WHERE name LIKE %?1%", nativeQuery = true)
    Page<Church> findByName(String search, Pageable pageable);
}

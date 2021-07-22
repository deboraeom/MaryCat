package com.example.MaryCatqapi.repository;



import com.example.MaryCatqapi.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface UserRepository extends JpaRepository<User,Long> {

      User findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE name LIKE %?1% or email LIKE %?2% or" +
            " andress LIKE %?3% or birth_date between ?4 and ?5", nativeQuery = true)
    Page<User> findBySearch(String name, String email, String address,String beginDate, String endDate,
                            Pageable pageable);



}

package com.example.MaryCatqapi.repository;

import com.example.MaryCatqapi.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {
}

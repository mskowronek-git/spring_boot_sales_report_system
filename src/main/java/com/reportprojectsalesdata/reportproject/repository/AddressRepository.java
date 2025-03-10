package com.reportprojectsalesdata.reportproject.repository;

import com.reportprojectsalesdata.reportproject.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

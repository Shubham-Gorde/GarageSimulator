package com.garage.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.simulator.dto.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}

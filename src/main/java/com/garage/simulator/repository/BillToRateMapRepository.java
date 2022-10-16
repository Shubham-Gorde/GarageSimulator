package com.garage.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.simulator.dto.BillToRateMap;

@Repository
public interface BillToRateMapRepository extends JpaRepository<BillToRateMap, Long> {

}

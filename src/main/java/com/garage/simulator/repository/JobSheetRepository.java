package com.garage.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.simulator.dto.JobSheet;

@Repository
public interface JobSheetRepository extends JpaRepository<JobSheet, Long> {

}

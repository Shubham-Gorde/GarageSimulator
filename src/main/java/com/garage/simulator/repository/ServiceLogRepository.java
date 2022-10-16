package com.garage.simulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.simulator.dto.ServiceLog;

@Repository
public interface ServiceLogRepository extends JpaRepository<ServiceLog, Long> {

	public ServiceLog findByServiceEntryId(long serviceEntryId);
}

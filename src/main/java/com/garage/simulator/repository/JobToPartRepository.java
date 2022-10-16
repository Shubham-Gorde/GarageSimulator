package com.garage.simulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.garage.simulator.dto.JobToPart;

@Repository
public interface JobToPartRepository extends JpaRepository<JobToPart, Long> {

	@Query(value = "select part_name from job_to_part where job_entry_id = ?1",nativeQuery = true)
	List<String> getJobParts(long jobEntryId);
}

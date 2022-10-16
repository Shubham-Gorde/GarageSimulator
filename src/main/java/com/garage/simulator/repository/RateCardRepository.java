package com.garage.simulator.repository;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.simulator.dto.RateCard;

@Repository
public interface RateCardRepository extends JpaRepository<RateCard, Long> {

	RateCard findByMotorCycleModelAndPartName(String motorCycleModel, String partName);

}

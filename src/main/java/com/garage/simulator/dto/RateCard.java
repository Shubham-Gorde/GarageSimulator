package com.garage.simulator.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rate_card")
public class RateCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rate_entry_id")
	long rateEntryId;

	@Column(name = "motor_cycle_model")
	String motorCycleModel;

	@Column(name = "part_name")
	String partName;

	@Enumerated(EnumType.STRING)
	@Column(name = "cost_type")
	CostType costType;

	@Column(name = "cost")
	Integer cost;

	public long getRateEntryId() {
		return rateEntryId;
	}

	public void setRateEntryId(long rateEntryId) {
		this.rateEntryId = rateEntryId;
	}

	public String getMotorCycleModel() {
		return motorCycleModel;
	}

	public void setMotorCycleModel(String motorCycleModel) {
		this.motorCycleModel = motorCycleModel;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public CostType getCostType() {
		return costType;
	}

	public void setCostType(CostType costType) {
		this.costType = costType;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "RateCard [rateEntryId=" + rateEntryId + ", motorCycleModel=" + motorCycleModel + ", partName="
				+ partName + ", costType=" + costType + ", cost=" + cost + "]";
	}
	
}

enum CostType {
	PART_COST, LABOUR_COST;
}
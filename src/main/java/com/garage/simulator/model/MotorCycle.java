package com.garage.simulator.model;

import javax.validation.constraints.NotNull;

public class MotorCycle {

	@NotNull(message="Please provide motorCycleModel")
	String motorCycleModel;
	
	@NotNull(message="Please provide numberPlate")
	String numberPlate;
	
	@NotNull(message="Please provide kmTravelled")
	Integer kmTravelled;

	public String getMotorCycleModel() {
		return motorCycleModel;
	}

	public void setMotorCycleModel(String motorCycleModel) {
		this.motorCycleModel = motorCycleModel;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public Integer getKmTravelled() {
		return kmTravelled;
	}

	public void setKmTravelled(Integer kmTravelled) {
		this.kmTravelled = kmTravelled;
	}

}

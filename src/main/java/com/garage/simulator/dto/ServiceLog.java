package com.garage.simulator.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_log")
public class ServiceLog {

	@Id
	@Column(name = "service_entry_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long serviceEntryId;

	@Column(name = "motor_cycle_model")
	private String motorCycleModel;

	@Column(name = "number_plate")
	private String numberPlate;

	@Column(name = "km_travelled")
	private int kmTravelled;

	@Column(name = "checked_in_time")
	private LocalDateTime checkedInTime;

	@Column(name = "checked_out_time")
	private LocalDateTime checkedOutTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_entry_id", referencedColumnName = "job_entry_id")
	private JobSheet jobSheet;

	public long getServiceEntryId() {
		return serviceEntryId;
	}

	public void setServiceEntryId(long serviceEntryId) {
		this.serviceEntryId = serviceEntryId;
	}

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

	public int getKmTravelled() {
		return kmTravelled;
	}

	public void setKmTravelled(int kmTravelled) {
		this.kmTravelled = kmTravelled;
	}

	public LocalDateTime getCheckedInTime() {
		return checkedInTime;
	}

	public void setCheckedInTime(LocalDateTime checkedInTime) {
		this.checkedInTime = checkedInTime;
	}

	public LocalDateTime getCheckedOutTime() {
		return checkedOutTime;
	}

	public void setCheckedOutTime(LocalDateTime checkedOutTime) {
		this.checkedOutTime = checkedOutTime;
	}

	public JobSheet getJobSheet() {
		return jobSheet;
	}

	public void setJobSheet(JobSheet jobSheet) {
		this.jobSheet = jobSheet;
	}

	
}

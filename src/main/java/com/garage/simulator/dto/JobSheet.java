package com.garage.simulator.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_sheet")
public class JobSheet {

	@Id
	@Column(name = "job_entry_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long jobEntryId;

	@OneToMany(mappedBy = "jobToPartMapId.jobSheet", cascade = CascadeType.ALL)
	private List<JobToPart> jobToParts;

	@OneToOne(mappedBy = "jobSheet")
	private ServiceLog serviceLog;

	public long getJobEntryId() {
		return jobEntryId;
	}

	public void setJobEntryId(long jobEntryId) {
		this.jobEntryId = jobEntryId;
	}

	public List<JobToPart> getJobToParts() {
		return jobToParts;
	}

	public void setJobToParts(List<JobToPart> jobToParts) {
		this.jobToParts = jobToParts;
	}

	public ServiceLog getServiceLog() {
		return serviceLog;
	}

	public void setServiceLog(ServiceLog serviceLog) {
		this.serviceLog = serviceLog;
	}

	
}

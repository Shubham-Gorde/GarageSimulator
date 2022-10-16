package com.garage.simulator.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class JobToPartMapId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "part_name")
	private String partName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_entry_id")
	private JobSheet jobSheet;

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public JobSheet getJobSheet() {
		return jobSheet;
	}

	public void setJobSheet(JobSheet jobSheet) {
		this.jobSheet = jobSheet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(jobSheet, partName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobToPartMapId other = (JobToPartMapId) obj;
		return Objects.equals(jobSheet, other.jobSheet) && Objects.equals(partName, other.partName);
	}

	
}

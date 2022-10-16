package com.garage.simulator.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "job_to_part")
public class JobToPart implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobToPartMapId jobToPartMapId;

	public JobToPartMapId getJobToPartMapId() {
		return jobToPartMapId;
	}

	public void setJobToPartMapId(JobToPartMapId jobToPartMapId) {
		this.jobToPartMapId = jobToPartMapId;
	}

}

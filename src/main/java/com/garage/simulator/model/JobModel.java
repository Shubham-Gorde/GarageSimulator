package com.garage.simulator.model;

import java.util.List;

public class JobModel {

	private long jobEntryId;
	private List<String> partList;

	public long getJobEntryId() {
		return jobEntryId;
	}

	public void setJobEntryId(long jobEntryId) {
		this.jobEntryId = jobEntryId;
	}

	public List<String> getPartList() {
		return partList;
	}

	public void setPartList(List<String> partList) {
		this.partList = partList;
	}

}

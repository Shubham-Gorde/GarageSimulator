package com.garage.simulator.dto;

import java.io.Serializable;
import java.util.Objects;

public class BillToRateMapId implements Serializable {

	private static final long serialVersionUID = 1L;

	private long billEntryId;

	private long rateEntryId;

	public long getBillEntryId() {
		return billEntryId;
	}

	public void setBillEntryId(long billEntryId) {
		this.billEntryId = billEntryId;
	}

	public long getRateEntryId() {
		return rateEntryId;
	}

	public void setRateEntryId(long rateEntryId) {
		this.rateEntryId = rateEntryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(billEntryId, rateEntryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillToRateMapId other = (BillToRateMapId) obj;
		return billEntryId == other.billEntryId && rateEntryId == other.rateEntryId;
	}

}

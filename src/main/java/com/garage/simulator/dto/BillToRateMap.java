package com.garage.simulator.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(BillToRateMapId.class)
@Table(name = "bill_to_rate_map")
public class BillToRateMap implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "bill_entry_id")
	private long billEntryId;

	@Id
	@Column(name = "rate_entry_id")
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

}

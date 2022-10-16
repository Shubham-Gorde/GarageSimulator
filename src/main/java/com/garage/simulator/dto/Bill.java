package com.garage.simulator.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_entry_id")
	long billEntryId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bill_to_rate_map", joinColumns = {
			@JoinColumn(name = "bill_entry_id", referencedColumnName = "bill_entry_id") }, inverseJoinColumns = {
					@JoinColumn(name = "rate_entry_id", referencedColumnName = "rate_entry_id") })
	List<RateCard> rateCardList;

	@Column(name = "total_cost")
	Integer totalCost;

	public long getBillEntryId() {
		return billEntryId;
	}

	public void setBillEntryId(long billEntryId) {
		this.billEntryId = billEntryId;
	}

	public List<RateCard> getRateCardList() {
		return rateCardList;
	}

	public void setRateCardList(List<RateCard> rateCardList) {
		this.rateCardList = rateCardList;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Bill [billEntryId=" + billEntryId + ", rateCardList=" + rateCardList + ", totalCost=" + totalCost + "]";
	}

	
}

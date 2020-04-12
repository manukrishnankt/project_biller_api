package com.ktbsoln.project_biller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country_states")
public class StatesVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "state_id")
	private Long stateId;

	@Column(name = "state_name")
	private String stateName;
	
	@Column(name = "state_country_id")
	private Long stateCountryId;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Long getStateCountryId() {
		return stateCountryId;
	}

	public void setStateCountryId(Long stateCountryId) {
		this.stateCountryId = stateCountryId;
	}
}

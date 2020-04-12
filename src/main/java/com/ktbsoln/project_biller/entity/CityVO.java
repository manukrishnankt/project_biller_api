package com.ktbsoln.project_biller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state_city")
public class CityVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "city_id")
	private Long cityId;

	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "city_state_id")
	private Long cityStateId;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getCityStateId() {
		return cityStateId;
	}

	public void setCityStateId(Long cityStateId) {
		this.cityStateId = cityStateId;
	}
}

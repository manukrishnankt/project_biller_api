package com.ktbsoln.project_biller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class CountryVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "country_id")
	private Long countryId;

	@Column(name = "country_sortname")
	private String countrySortName;
	
	@Column(name = "country_name")
	private String countryName;
	
	@Column(name = "country_phone")
	private String countryPhone;

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountrySortName() {
		return countrySortName;
	}

	public void setCountrySortName(String countrySortName) {
		this.countrySortName = countrySortName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryPhone() {
		return countryPhone;
	}

	public void setCountryPhone(String countryPhone) {
		this.countryPhone = countryPhone;
	}
}

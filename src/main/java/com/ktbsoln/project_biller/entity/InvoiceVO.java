package com.ktbsoln.project_biller.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class InvoiceVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "invoice_id")
	private Long invoiceId;

	@Column(name = "invoice_date")
	private Timestamp invoiceDate;
	
	@Column(name = "invoice_amount")
	private Long invoiceAmount;

	@Column(name = "invoice_customer_id")
	private Long invoiceCustomerId;
	
	@Column(name = "invoice_received_amount")
	private Long invoiceReceivedAmount;

	@Column(name = "invoice_record_status")
	private String invoiceRecordStatus;

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Timestamp getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Long getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Long invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Long getInvoiceCustomerId() {
		return invoiceCustomerId;
	}

	public void setInvoiceCustomerId(Long invoiceCustomerId) {
		this.invoiceCustomerId = invoiceCustomerId;
	}

	public Long getInvoiceReceivedAmount() {
		return invoiceReceivedAmount;
	}

	public void setInvoiceReceivedAmount(Long invoiceReceivedAmount) {
		this.invoiceReceivedAmount = invoiceReceivedAmount;
	}

	public String getInvoiceRecordStatus() {
		return invoiceRecordStatus;
	}

	public void setInvoiceRecordStatus(String invoiceRecordStatus) {
		this.invoiceRecordStatus = invoiceRecordStatus;
	}

}

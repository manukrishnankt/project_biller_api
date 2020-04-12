package com.ktbsoln.project_biller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetailsVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "invdetails_id")
	private Long invoiceDetailsId;

	@Column(name = "invdetails_invoice_id")
	private Long invoiceDetailsInvoiceId;
	
	@Column(name = "invdetails_product_id")
	private Long invoiceDetailsProductId;

	@Column(name = "invdetails_quantity")
	private Long invoiceDetailsQuantity;
	
	@Column(name = "invdetails_unit")
	private String invoiceDetailsUnit;

	@Column(name = "invdetails_record_status")
	private String invoiceDetailsRecordStatus;

	public Long getInvoiceDetailsId() {
		return invoiceDetailsId;
	}

	public void setInvoiceDetailsId(Long invoiceDetailsId) {
		this.invoiceDetailsId = invoiceDetailsId;
	}

	public Long getInvoiceDetailsInvoiceId() {
		return invoiceDetailsInvoiceId;
	}

	public void setInvoiceDetailsInvoiceId(Long invoiceDetailsInvoiceId) {
		this.invoiceDetailsInvoiceId = invoiceDetailsInvoiceId;
	}

	public Long getInvoiceDetailsProductId() {
		return invoiceDetailsProductId;
	}

	public void setInvoiceDetailsProductId(Long invoiceDetailsProductId) {
		this.invoiceDetailsProductId = invoiceDetailsProductId;
	}

	public Long getInvoiceDetailsQuantity() {
		return invoiceDetailsQuantity;
	}

	public void setInvoiceDetailsQuantity(Long invoiceDetailsQuantity) {
		this.invoiceDetailsQuantity = invoiceDetailsQuantity;
	}

	public String getInvoiceDetailsUnit() {
		return invoiceDetailsUnit;
	}

	public void setInvoiceDetailsUnit(String invoiceDetailsUnit) {
		this.invoiceDetailsUnit = invoiceDetailsUnit;
	}

	public String getInvoiceDetailsRecordStatus() {
		return invoiceDetailsRecordStatus;
	}

	public void setInvoiceDetailsRecordStatus(String invoiceDetailsRecordStatus) {
		this.invoiceDetailsRecordStatus = invoiceDetailsRecordStatus;
	}
}

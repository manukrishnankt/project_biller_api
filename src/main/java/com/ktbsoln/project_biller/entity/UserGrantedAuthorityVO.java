package com.ktbsoln.project_biller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_granted_authority")
public class UserGrantedAuthorityVO {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="user_granted_authority_id")
    private Long userGrantedAuthorityId;
     
    @Column(name="user_granted_authority_authority_id")
    private Long userGrantedAuthorityAuthorityId;

    @Column(name="user_granted_authority_login_credential_id")
    private Long userGrantedAuthorityLoginCredentialId;
    
    @Column(name="user_granted_authority_record_status")
    private String userGrantedAuthorityRecordStatus ;

	public Long getUserGrantedAuthorityId() {
		return userGrantedAuthorityId;
	}

	public void setUserGrantedAuthorityId(Long userGrantedAuthorityId) {
		this.userGrantedAuthorityId = userGrantedAuthorityId;
	}

	public Long getUserGrantedAuthorityAuthorityId() {
		return userGrantedAuthorityAuthorityId;
	}

	public void setUserGrantedAuthorityAuthorityId(Long userGrantedAuthorityAuthorityId) {
		this.userGrantedAuthorityAuthorityId = userGrantedAuthorityAuthorityId;
	}

	public Long getUserGrantedAuthorityLoginCredentialId() {
		return userGrantedAuthorityLoginCredentialId;
	}

	public void setUserGrantedAuthorityLoginCredentialId(Long userGrantedAuthorityLoginCredentialId) {
		this.userGrantedAuthorityLoginCredentialId = userGrantedAuthorityLoginCredentialId;
	}

	public String getUserGrantedAuthorityRecordStatus() {
		return userGrantedAuthorityRecordStatus;
	}

	public void setUserGrantedAuthorityRecordStatus(String userGrantedAuthorityRecordStatus) {
		this.userGrantedAuthorityRecordStatus = userGrantedAuthorityRecordStatus;
	}

}

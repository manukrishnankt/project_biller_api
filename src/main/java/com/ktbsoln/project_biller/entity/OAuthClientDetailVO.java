package com.ktbsoln.project_biller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_client_details")
public class OAuthClientDetailVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "client_id_name")
	private String clientIdName;

	@Column(name = "resource_ids")
	private String resourceId;
	
	@Column(name = "authorized_grant_types")
	private String authorizedGrantTypes;
	
	@Column(name = "client_secret")
	private String clientSecret;
	
	@Column(name = "scope")
	private String Scope;
	
	@Column(name = "web_server_redirect_uri")
	private String redirectUri;
	
	@Column(name = "authorities")
	private String authorities;
	
	@Column(name = "access_token_validity")
	private long accessTokenValidity;
	
	@Column(name = "refresh_token_validity")
	private long refreshTokenValidity;
	
	@Column(name = "additional_information")
	private String additionalInformation;
	
	@Column(name = "autoapprove")
	private boolean autoApprove;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientIdName() {
		return clientIdName;
	}

	public void setClientIdName(String clientIdName) {
		this.clientIdName = clientIdName;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return Scope;
	}

	public void setScope(String scope) {
		Scope = scope;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public long getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(long accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public long getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(long refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public boolean isAutoApprove() {
		return autoApprove;
	}

	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}
}

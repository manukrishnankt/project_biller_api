package com.ktbsoln.project_biller.config.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class AuthClientDetail implements ClientDetails {

	private static final long serialVersionUID = -6306538266068211036L;
	private String clientId;
	private Set<String> resourceIds;
	private boolean isSecretYN;
	private String clientSecret;
	private boolean scopeYN;
	private Set<String> scopes;
	private Set<String> authGrantTypes;
	private Set<String> redirectUris;
	private List<GrantedAuthority> grantedAuth;
	private int accessTokenValidity;
	private int refreshTokenValidity;
	private boolean isAutoApproveYN;

	public AuthClientDetail() {}
	
	
	public AuthClientDetail(String clientId, Set<String> resourceIds, boolean isSecretYN, String clientSecret,
			boolean scopeYN, Set<String> scopes, Set<String> authGrantTypes, Set<String> redirectUris,
			List<GrantedAuthority> grantedAuth, int accessTokenValidity, int refreshTokenValidity,
			boolean isAutoApproveYN) {
		
		this.clientId = clientId;
		this.resourceIds = resourceIds;
		this.isSecretYN = isSecretYN;
		this.clientSecret = clientSecret;
		this.scopeYN = scopeYN;
		this.scopes = scopes;
		this.authGrantTypes = authGrantTypes;
		this.redirectUris = redirectUris;
		this.grantedAuth = grantedAuth;
		this.accessTokenValidity = accessTokenValidity;
		this.refreshTokenValidity = refreshTokenValidity;
		this.isAutoApproveYN = isAutoApproveYN;
	}
	
	@Override
	public String getClientId() {
		return this.clientId;
	}
	@Override
	public Set<String> getResourceIds() {
		return this.resourceIds;
	}
	@Override
	public boolean isSecretRequired() {
		return this.isSecretYN;
	}

	@Override
	public String getClientSecret() {
		return this.clientSecret;
	}

	@Override
	public boolean isScoped() {
		return this.scopeYN;
	}

	@Override
	public Set<String> getScope() {
		return this.scopes;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return this.authGrantTypes;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return this.redirectUris;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.grantedAuth;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return this.accessTokenValidity;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return this.refreshTokenValidity;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return this.isAutoApproveYN;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

}

package com.ktbsoln.project_biller.config.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.ktbsoln.project_biller.entity.AuthorityVO;
import com.ktbsoln.project_biller.entity.OAuthClientDetailVO;
import com.ktbsoln.project_biller.repository.AuthorityRepository;

@Service
public class AuthClientDetailService implements ClientDetailsService{

	@Autowired
	private AuthorityRepository authRepository;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		OAuthClientDetailVO oauthClient = authRepository.findByClientId(clientId);
		AuthClientDetail authClientDetail = null;
		if(oauthClient != null) {
			List<AuthorityVO> authorityList = authRepository.findAuthortyByClientId(oauthClient.getClientId());
			Set<String> resourceIds = Arrays.asList(oauthClient.getResourceId().split(",")).stream().collect(Collectors.toSet());
			boolean isSecretYN = true;
			String clientSecret = oauthClient.getClientSecret();
			boolean scopeYN = true;
			Set<String> scopes = Arrays.asList(oauthClient.getScope().split(",")).stream().collect(Collectors.toSet());
			Set<String> authGrantTypes = Arrays.asList(oauthClient.getAuthorizedGrantTypes().split(",")).stream().collect(Collectors.toSet());
			Set<String> redirectUris = Arrays.asList(oauthClient.getRedirectUri().split(",")).stream().collect(Collectors.toSet());

			List<GrantedAuthority> grantedAuth = authorityList.stream()
					.map(list -> new SimpleGrantedAuthority(list.getAuthorityName())).collect(Collectors.toList());
			
			Long accessTokenValidity = oauthClient.getAccessTokenValidity();
			Long refreshTokenValidity = oauthClient.getRefreshTokenValidity();
			authClientDetail = new AuthClientDetail(clientId, resourceIds, isSecretYN, clientSecret, 
					scopeYN, scopes, authGrantTypes, redirectUris, grantedAuth, accessTokenValidity.intValue(), 
					refreshTokenValidity.intValue(), oauthClient.isAutoApprove());
		}
		if(authClientDetail == null) {
			throw new ClientRegistrationException("No Client Found !!!");
		}
		return authClientDetail;
	}

}

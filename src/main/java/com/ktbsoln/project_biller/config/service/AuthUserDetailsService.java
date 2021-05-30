package com.ktbsoln.project_biller.config.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ktbsoln.project_biller.dto.LoginCredentialDto;
import com.ktbsoln.project_biller.entity.AuthorityVO;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.repository.AuthorityRepository;
import com.ktbsoln.project_biller.repository.LoginCredentialRepository;
import com.ktbsoln.project_biller.utils.PBillerConstants;
import com.ktbsoln.project_biller.utils.PBillerEncryptionDecryption;

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	LoginCredentialRepository loginCredentialRepository;
	@Autowired
	AuthorityRepository authorityRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LoginCredentialVO loginCredential= loginCredentialRepository.getByUserName(userName);
		LoginCredentialDto userDto = null;
		AuthUserDetail authUserDetail = null;
		if (loginCredential != null) {
			List<AuthorityVO> authorityList = authorityRepository.findByLoginCredenialId(loginCredential.getLoginCredentialId());
			if (!authorityList.isEmpty() && authorityList != null) {
				List<GrantedAuthority> grantedAuthorityList = authorityList.stream()
						.map(list -> new SimpleGrantedAuthority(list.getAuthorityName())).collect(Collectors.toList());
				String decryptPassword = PBillerEncryptionDecryption.decrypt(loginCredential.getLoginCredentialPassword(), PBillerConstants.PBILLER_ENC_DEC_SECRECT_KEY);
				userDto= new LoginCredentialDto(loginCredential.getLoginCredentialId(), loginCredential.getLoginCredentialUserName(), 
						decryptPassword, loginCredential.getLoginCredentialRecordStatus(), grantedAuthorityList);
				authUserDetail = new AuthUserDetail(userDto);
			}
		}else {
			throw new UsernameNotFoundException(userName+" Not Found!");
		}
		return authUserDetail;
	}
}

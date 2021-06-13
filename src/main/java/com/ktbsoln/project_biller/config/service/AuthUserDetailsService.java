package com.ktbsoln.project_biller.config.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ktbsoln.project_biller.dto.LoginCredentialDto;
import com.ktbsoln.project_biller.dto.UserDto;
import com.ktbsoln.project_biller.entity.AuthorityVO;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.entity.UserGrantedAuthorityVO;
import com.ktbsoln.project_biller.repository.AuthorityRepository;
import com.ktbsoln.project_biller.repository.LoginCredentialRepository;
import com.ktbsoln.project_biller.repository.UserGrantedAuthorityRepository;
import com.ktbsoln.project_biller.utils.PBillerConstants;

@Service
public class AuthUserDetailsService implements UserDetailsService {

	@Autowired
	LoginCredentialRepository loginCredentialRepository;
	@Autowired
	AuthorityRepository authorityRepository;
	@Autowired
	UserGrantedAuthorityRepository userGrantedAuthorityRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

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
				userDto= new LoginCredentialDto(loginCredential.getLoginCredentialId(), loginCredential.getLoginCredentialUserName(), 
						loginCredential.getLoginCredentialPassword(), loginCredential.getLoginCredentialRecordStatus(), grantedAuthorityList);
				authUserDetail = new AuthUserDetail(userDto);
			}
		}else {
			throw new UsernameNotFoundException(userName+" Not Found!");
		}
		return authUserDetail;
	}
	
	public String saveUser(UserDto userDto, Long orgId) {
		Gson g = new Gson();
		String json = g.toJson(userDto);
		String response = "";
		try {
			LoginCredentialVO lcVO = loginCredentialRepository.findByLoginCredentialUserName(userDto.getLoginCredentialUserName());
			if (lcVO != null) {
				response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"USERNAME EXISTS!\"}";
				return response;
			}
			LoginCredentialVO loginCredentialVO = new Gson().fromJson(json, LoginCredentialVO.class);
			loginCredentialVO.setLoginCredentialRecordStatus(PBillerConstants.RECORD_STATUS_ACTIVE);
			loginCredentialVO.setLoginCredentialCreatedDate(new Timestamp(System.currentTimeMillis()));
			loginCredentialVO.setLoginCredentialPassword(passwordEncoder.encode(userDto.getLoginCredentialPassword()));
			loginCredentialVO = loginCredentialRepository.save(loginCredentialVO);
			
			UserGrantedAuthorityVO ugAuthorityVO = new UserGrantedAuthorityVO();
			ugAuthorityVO.setUserGrantedAuthorityLoginCredentialId(loginCredentialVO.getLoginCredentialId());
			ugAuthorityVO.setUserGrantedAuthorityRecordStatus(PBillerConstants.RECORD_STATUS_ACTIVE);
			ugAuthorityVO.setUserGrantedAuthorityAuthorityId(userDto.getAuthorityId());
			userGrantedAuthorityRepository.save(ugAuthorityVO);
			response = "{\"STATUS\":\"OK\",\"DESCRIPTION\":\"USER SAVED SUCCESSFULLY\"}";
		} catch (Exception e) {
			response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\""+e.getMessage()+"\"}";
		}
		return response;
	}
}

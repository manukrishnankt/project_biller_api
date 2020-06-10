package com.ktbsoln.project_biller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.AuthorityVO;
import com.ktbsoln.project_biller.entity.OAuthClientDetailVO;

@Repository
public interface AuthorityRepository  extends JpaRepository<AuthorityVO, Long>{
	
	@Query(value = "SELECT authority.* FROM user_granted_authority INNER JOIN authority ON " + 
			"user_granted_authority.user_granted_authority_authority_id = authority.authority_id " + 
			"WHERE user_granted_authority.user_granted_authority_login_credential_id=?1", nativeQuery = true)
	List<AuthorityVO> findByLoginCredenialId(long userId);
	
	@Query(value = "SELECT oc FROM OAuthClientDetailVO oc WHERE oc.clientIdName=?1")
	OAuthClientDetailVO findByClientId(String clientId);

	@Query(value = "SELECT authority.* FROM client_granted_authority INNER JOIN authority ON " + 
			"client_granted_authority.granted_authority_authority_id = authority.authority_id " + 
			"WHERE client_granted_authority.granted_authority_client_id=?1", nativeQuery = true)
	List<AuthorityVO> findAuthortyByClientId(Long clientId);
}

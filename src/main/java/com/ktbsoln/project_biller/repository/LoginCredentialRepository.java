package com.ktbsoln.project_biller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.LoginCredentialVO;

@Repository
public interface LoginCredentialRepository  extends JpaRepository<LoginCredentialVO, Long>{
	@Query(value="SELECT lc FROM login_credential lc INNER JOIN company"+
				" AS c ON lc.lc_id = c.company_login_credential_id WHERE lc.lc_username=?1"+
				" AND lc.lc_password=?2 AND c.company_name=?3")
	LoginCredentialVO checkLoginCredential(String userName, String password, String companyName);

}

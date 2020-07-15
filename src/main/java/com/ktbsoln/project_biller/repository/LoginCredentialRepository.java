package com.ktbsoln.project_biller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.CompanyVO;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.utils.PBillerConstants;

@Repository
public interface LoginCredentialRepository  extends JpaRepository<LoginCredentialVO, Long>{
	@Query(value="SELECT lc FROM login_credential lc INNER JOIN company"+
				" AS c ON lc.lc_id = c.company_login_credential_id WHERE lc.lc_username=?1"+
				" AND lc.lc_password=?2 AND c.company_name=?3",nativeQuery = true)
	LoginCredentialVO checkLoginCredential(String userName, String password, String companyName);

	@Query(value="SELECT lc FROM LoginCredentialVO lc WHERE lc.loginCredentialUserName=?1 AND"+
				" lc.loginCredentialRecordStatus='"+PBillerConstants.RECORD_STATUS_ACTIVE+"'")
	LoginCredentialVO getByUserName(String userName);
	
	@Query(value="SELECT c FROM login_credential lc INNER JOIN company"+
			" AS c ON lc.lc_id = c.company_login_credential_id WHERE lc.lc_username=?2"+
			" AND c.company_name=?1",nativeQuery = true)
	CompanyVO getComapnyDetails(String loginCredentialComapnyName, String userName);
	
	@Query(value="SELECT lc.lc_id FROM login_credential lc INNER JOIN company"+
			" AS c ON lc.lc_id = c.company_login_credential_id WHERE lc.lc_username=?2"+
			" AND c.company_name=?1",nativeQuery = true)
	Long getUserId(String loginCredentialComapnyName, String userName);
}

package com.ktbsoln.project_biller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.CompanyVO;

@Repository
public interface CompanyRepository  extends JpaRepository<CompanyVO, Long>{
	@Query(value="SELECT company.* FROM login_credential  INNER JOIN company"+
			" ON login_credential.lc_company_id = company.company_id WHERE login_credential.lc_username=?2"+
			" AND company.company_name=?1",nativeQuery = true)
	CompanyVO getComapnyDetails(String loginCredentialComapnyName, String userName);
	
	@Query(value="SELECT lc.lc_id FROM login_credential lc INNER JOIN company"+
			" AS c ON lc.lc_company_id = c.company_id WHERE lc.lc_username=?2"+
			" AND c.company_name=?1",nativeQuery = true)
	Long getUserId(String loginCredentialComapnyName, String userName);
}

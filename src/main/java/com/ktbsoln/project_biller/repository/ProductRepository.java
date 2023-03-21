package com.ktbsoln.project_biller.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.ProductVO;

@Repository
public interface ProductRepository  extends JpaRepository<ProductVO, Long>{
	List<ProductVO> findByProductCompanyId(Long orgId);
	
	@Query(value="select * from product where product_company_id=?2 and product_name=?1", nativeQuery = true)
	Set<ProductVO> findByProNameAndCompanyId(String proName, Long orgid);

	List<ProductVO> findByProductNameAndProductCompanyId(String productName, Long orgId);
	
	@Query(value = "SELECT * from parents p inner join children c on c.id=p.childId where TIMESTAMPDIFF(SECOND, p.ts, CURRENT_TIMESTAMP) < :interval", nativeQuery = true)
    List<Object[]> findOneByInterval(@Param("interval") long interval);
    
}

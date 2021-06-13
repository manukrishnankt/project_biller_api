package com.ktbsoln.project_biller.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.ProductCatagoryVO;

@Repository
public interface ProductCatagoryRepository  extends JpaRepository<ProductCatagoryVO, Long>{
	@Query(value="select * from product_catagory where pro_catagory_company_id=?2 and pro_catagory_name=?1", nativeQuery = true)
	Set<ProductCatagoryVO> findByProCatagoryNameProCatagoryCompanyId(String proCatagoryName, Long orgid);

	List<ProductCatagoryVO> findByProCatagoryCompanyId(Long orgId);
}

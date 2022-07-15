package com.ktbsoln.project_biller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.ProductVO;

@Repository
public interface ProductRepository  extends JpaRepository<ProductVO, Long>{
	List<ProductVO> findByProductCompanyId(Long orgId);
}

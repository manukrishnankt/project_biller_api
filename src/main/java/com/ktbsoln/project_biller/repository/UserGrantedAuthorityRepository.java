package com.ktbsoln.project_biller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ktbsoln.project_biller.entity.UserGrantedAuthorityVO;

@Repository
public interface UserGrantedAuthorityRepository  extends JpaRepository<UserGrantedAuthorityVO, Long>{
}

package com.retail.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.app.domain.Metal;

@Repository
public interface MetalRepository extends JpaRepository<Metal, Long>{

}

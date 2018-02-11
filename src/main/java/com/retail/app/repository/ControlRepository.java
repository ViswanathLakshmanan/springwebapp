package com.retail.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.app.domain.Control;

@Repository
public interface ControlRepository extends JpaRepository<Control, Long>{

}

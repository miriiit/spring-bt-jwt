package com.mirit.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mirit.models.Ground;


public interface IGroundRepository extends JpaRepository<Ground, Long> {

}

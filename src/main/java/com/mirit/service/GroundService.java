package com.mirit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirit.models.Ground;
import com.mirit.repository.IGroundRepository;

@Service
public class GroundService {

	private final IGroundRepository groundREpository;
	
	@Autowired
	public GroundService(IGroundRepository groundRepository) {
		this.groundREpository = groundRepository;
	}
	
	public Ground saveGround(Ground ground) {
		return groundREpository.save(ground);
	}

}

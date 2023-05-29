package com.mirit.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirit.repository.IUserRepository;

import jakarta.annotation.PostConstruct;

//@Component
public class IntialzerH2Data {


	private IUserRepository userRep;
	
	@Autowired
	public IntialzerH2Data(IUserRepository repo) {
		this.userRep = repo;
	}

	@PostConstruct
	public void loadInitialData() {
//		User user1 = new User("John", "324", null);
//		User user2 = new User("Jane", "wret", null);
//		userRep.saveAll(List.of(user1, user2));
	}
}

package com.nitin.jobConnect.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.client.MongoClient;
import com.nitin.jobConnect.POJOs.Profiles;
import com.nitin.jobConnect.Reporsitory.ProfilesRepo;
import com.nitin.jobConnect.Reporsitory.TaskRepo;

public class ProfileService_Impl implements ProfileService {

	MongoClient client;

	@Autowired(required = true)
	ProfilesRepo repo;

	@Override
	public List<Profiles> searchProfileByText(String text) {
		final List<Profiles> profiles = new ArrayList<>();

		return profiles;
	}
}

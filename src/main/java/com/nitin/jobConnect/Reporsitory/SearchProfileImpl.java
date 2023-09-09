package com.nitin.jobConnect.Reporsitory;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoClient;
import com.nitin.jobConnect.POJOs.Profiles;

public class SearchProfileImpl implements SearchProfile{
	
	MongoClient client;
	
	@Override
	public List<Profiles> searchProfileByText(String text) {
		final List<Profiles> profiles = new ArrayList<>();

		return profiles;
	}

}

package com.nitin.jobConnect.Reporsitory;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.nitin.jobConnect.POJOs.Profiles;

public interface ProfilesRepo extends MongoRepository<Profiles, String> {
	
}

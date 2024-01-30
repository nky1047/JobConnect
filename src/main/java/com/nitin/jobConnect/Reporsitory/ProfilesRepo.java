package com.nitin.jobConnect.Reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nitin.jobConnect.POJOs.Profiles;
import com.nitin.jobConnect.POJOs.Task;

public interface ProfilesRepo extends JpaRepository<Profiles, Long> {

}

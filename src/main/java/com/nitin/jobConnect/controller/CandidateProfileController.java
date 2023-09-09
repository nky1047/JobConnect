package com.nitin.jobConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.jobConnect.POJOs.Profiles;
import com.nitin.jobConnect.Reporsitory.ProfilesRepo;
import com.nitin.jobConnect.Reporsitory.SearchProfile;

@RestController
public class CandidateProfileController {

	@Autowired
	ProfilesRepo profileRepo;
	
	Profiles profile;

	SearchProfile searchRepo;

	@GetMapping("/profiles")
	public List<Profiles> getAllProfiles() {
		System.out.println("----------------------All Profiles Fetched!----------------------");
		return profileRepo.findAll();
	}

	@PostMapping("saveProfile")
	public Profiles saveProfile(@RequestBody Profiles profile) {
		return profileRepo.save(profile);
	}
	
	@PutMapping("updateProfile")
	public Profiles updateProfile(@RequestBody Profiles profile) {
		return profileRepo.save(profile);
	}

	@GetMapping("/profile/{text}")
	public List<Profiles> searchProfile(@PathVariable String text) {
		return searchRepo.searchProfileByText(text);
	}
}

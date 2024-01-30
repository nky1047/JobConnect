package com.nitin.jobConnect.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.jobConnect.POJOs.Profiles;
import com.nitin.jobConnect.Reporsitory.ProfilesRepo;
import com.nitin.jobConnect.Service.ProfileService;

@RestController
public class Profiles_of_Candidates_Controller {
	
	//Logger to get log on console
		private static final Logger Log = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	ProfilesRepo profileRepo; // Profile Repository Instance

	ProfileService profile_service; // Profile Service Instance

	Profiles profile; // Profile Object

	@GetMapping("/profiles")
	public List<Profiles> getAllProfiles() {
		System.out.println("----------------------All Profiles Fetched!----------------------");
		Log.info("All Profiles Fetched!!");
		return profileRepo.findAll();
	}

	@PostMapping("saveProfile")
	public Profiles saveProfile(@RequestBody @NonNull Profiles profile) {
		return profileRepo.save(profile);
	}

	@PutMapping("updateProfile")
	public Profiles updateProfile(@RequestBody @NonNull Profiles profile) {
		return profileRepo.save(profile);
	}

	@GetMapping("/profile/{text}")
	public List<Profiles> searchProfile(@PathVariable String text) {
		return profile_service.searchProfileByText(text);
	}
	
	
//	DELETE A TASK
	@DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id){
		profileRepo.deleteById(id);
       
        return "Deleted Successfully";
    }
	/*
	 * @DeleteMapping("/{id}") public ResponseEntity<Boolean>
	 * deleteTaskByTaskId(@PathVariable Long id){
	 * Log.info("A Task with "+id+"is DELETED!"); taskService.deleteTaskById(id);
	 * return ResponseEntity.ok(true); }
	 */
}

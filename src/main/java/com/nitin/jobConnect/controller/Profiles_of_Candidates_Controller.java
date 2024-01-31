package com.nitin.jobConnect.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.jobConnect.POJOs.Profiles;
import com.nitin.jobConnect.POJOs.Task;
import com.nitin.jobConnect.Reporsitory.ProfilesRepo;
import com.nitin.jobConnect.Service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class Profiles_of_Candidates_Controller {

	// Logger to get log on console
	private static final Logger Log = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	ProfilesRepo profileRepo; // Profile Repository Instance

	ProfileService profile_service; // Profile Service Instance
	Profiles profile; // Profile Object

	
//	ALL PROFILES-------------
	@GetMapping("/all")
	public List<Profiles> getAllProfiles() {
		System.out.println("----------------------All Profiles Fetched!----------------------");
		
		Log.info("All Profiles Fetched!!");
		System.out.println(profileRepo.findAll());
		return profileRepo.findAll();
	}

//	SAVE NEW PROFILE-------------
	@PostMapping("saveProfile")
	public String saveProfile(@RequestBody @NonNull Profiles profile) {

		System.out.println("Profile save called...");

		// a new Profile
		Profiles profile1 = new Profiles(profile.getJBid(), profile.getName(), profile.getCurrentCompany(),
				profile.getYoe(), profile.getSkillsList(), profile.getDesignation(), profile.getTasksList());

		// list of Task
		List<Task> tasklist = new ArrayList<>();
		for (Task task : profile.getTasksList()) {
			// new Task
			Task task1 = new Task(task.getTaskId(), task.getDate(), task.getTime(), task.getTaskName(),task.getTaskDesc(), task.isCompleted(), task.getProfile());
			// set Profile to Task
			task.setProfile(profile1);
			// add task to new task_list
			tasklist.add(task1);
		}

		// add task list to profile
		profile1.setTasksList(tasklist);

		// save profile
		Profiles profileOut = profileRepo.save(profile1);
		System.out.println("Profile out :: " + profileOut);

		System.out.println("Saved!!!");
		return "Profile saved!!!";
	}
	
//	GET PROFILE BY ID-----------
	@GetMapping("/getProfile/{id}")
    public String getProfile(@PathVariable(name = "id") String id) {
        System.out.println("Profile get called...");

	// fetch Owner
        @SuppressWarnings("deprecation")
		Profiles profileOut = profileRepo.getById(Long.valueOf(id));
        System.out.println("\nProfile details :: \n" + profileOut);
        System.out.println("\nList of Blogs :: \n" + profileOut.getTasksList());

        System.out.println("\nDone!!!");
        return "Owner fetched...";
    }
	
//	UPDATE PROFILE------------
	@PutMapping("updateProfile")
	public Profiles updateProfile(@RequestBody @NonNull Profiles profile) {
		return profileRepo.save(profile);
	}

//	SEARCH PROFILE BY NAME
	@GetMapping("/profile/{text}")
	public List<Profiles> searchProfile(@PathVariable String text) {
		return profile_service.searchProfileByText(text);
	}

//	DELETE A TASK
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable long id) {
		profileRepo.deleteById(id);

		return "Deleted Successfully";
	}

}

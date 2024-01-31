package com.nitin.jobConnect.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.jobConnect.POJOs.Profiles;
import com.nitin.jobConnect.POJOs.Task;
import com.nitin.jobConnect.Reporsitory.ProfilesRepo;
import com.nitin.jobConnect.Reporsitory.TaskRepo;
import com.nitin.jobConnect.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(value = "http://localhost:4200")
public class TaskController {

	// Logger to get log on console
	private static final Logger Log = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	TaskService taskService;

	TaskRepo taskRepo;

	ProfilesRepo profileRepo;

//	VIEW TASK BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Task> viewTaskById(@PathVariable Long id) {
		Log.info("Viewed a Task!");
		return (ResponseEntity<Task>) taskService.findTaskById(id);
	}

//	VIEW TASK BY NAME ----------------[Returns list of Tasks with Same Name] 
	@GetMapping("/{taskName}")
	public ResponseEntity<Task> viewTaskByName(@PathVariable String taskName) {
		Log.info("Viewed a Task!");
//		taskService.getAllTasks().containsAll(null)
		return (ResponseEntity<Task>) taskService.findByTaskName(taskName);
	}

//	VIEW ALL TASKS
	@GetMapping("/")
	public ResponseEntity<List<Task>> getAllTasks() {
		Log.info("Viewed All Tasks!");

		return ResponseEntity.ok(taskService.getAllTasks());
	}

//	VIEW ALL COMPLETED TASKS
	@GetMapping("/completed")
	public ResponseEntity<List<Task>> getAllCompletedTasks() {
		Log.info("getAllCompletedTasks!");
		return ResponseEntity.ok(taskService.findAllCompletedTask());
	}

//	VIEW ALL INCOMPLETE TASKS
	@GetMapping("/incomplete")
	public ResponseEntity<List<Task>> getAllIncompletedTasks() {
		Log.info("getAllIncompletedTasks!");
		return ResponseEntity.ok(taskService.findAllCompletedTask());
	}

//	CREATE NEW TASK
	@PostMapping("/new")
	public ResponseEntity<Task> createTasks(@RequestBody Task task) {
		Log.info("New Task Created!");
		return ResponseEntity.ok(taskService.createNewTask(task));
	}

	@PostMapping("/saveTask")
	public String saveTask(@RequestParam String id) {
		System.out.println("Task save called...");

		// list of Task
		List<Task> tasks = new ArrayList<>();
		
		// fetch Profile
		if (profileRepo != null) {
			Profiles profile = profileRepo.getById(Long.valueOf(id));
		
//	        Profiles profile = profileRepo.getById(null)

	

		// new Task
		String localDate = java.time.LocalDate.now().toString();
		String localtime = java.time.LocalTime.now().toString();
//	    	long taskId, String date, String time, String taskName, String taskDesc, boolean isCompleted, Profiles profile
		Task task1 = new Task(localDate, localtime, "My New Task!", "Description of Task!", false, profile);
		Task task2 = new Task(localDate, localtime, "My New Task2!", "Description of Task!", false, profile);
		Task task3 = new Task(localDate, localtime, "My New Task3!", "Description of Task!", false, profile);

		// set owner to task
		task1.setProfile(profile);
		task2.setProfile(profile);
		task3.setProfile(profile);
		// add Task to list
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);

		Task task4 = new Task(localDate, localtime, "My New Task4!", "Description of Task!", false, profile);
		Task task5 = new Task(localDate, localtime, "My New Task5!", "Description of Task!", false, profile);
		// set owner to task
		task4.setProfile(profile);
		task5.setProfile(profile);

		tasks.add(task4);
		tasks.add(task5);

		// add Task list to Owner
		profile.setTasksList(tasks);

		// save Owner
		profileRepo.save(profile);
		}
		System.out.println("Saved!!!");
		return "Task saved!!!";
	}

//	 GET TASK BY PROFILE ID
	@GetMapping("/getTask/{id}")
	public String getBlog(@PathVariable(name = "id") String id) {
		System.out.println("Blog get called...");

		// fetch Task
		Task taskOut = taskRepo.getById(Long.valueOf(id));
		System.out.println("\nTask details :: \n" + taskOut);
		System.out.println("\nOwner details :: \n" + taskOut.getProfile());

		System.out.println("\nDone!!!");
		return "Task fetched...";
	}

//	UPDATE A TASK
	@PutMapping("/{id}")
	public ResponseEntity<Task> editTask(@PathVariable Long id, @RequestBody Task task) {
		task.setTaskId(id);
		return ResponseEntity.ok(taskService.updateTask(task));
	}

//	DELETE A TASK
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTaskByTaskId(@PathVariable Long id) {
		Log.info("A Task with " + id + "is DELETED!");
		taskService.deleteTaskById(id);
		return ResponseEntity.ok(true);
	}
}

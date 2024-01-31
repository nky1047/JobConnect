package com.nitin.jobConnect.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.nitin.jobConnect.POJOs.Task;
import com.nitin.jobConnect.Reporsitory.TaskRepo;

public interface TaskService {

	Task createNewTask(Task task);

	List<Task> getAllTasks();

	public ResponseEntity<Task> findByTaskName(String taskName);

	public ResponseEntity<Task> findTaskById(Long id);

	public List<Task> findAllCompletedTask();
	
	public List<Task> findInCompleteTask();
	
	public Task updateTask(Task task);
	
	public void deleteTaskById(Long id);
	

}

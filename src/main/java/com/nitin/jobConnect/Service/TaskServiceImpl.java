package com.nitin.jobConnect.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.nitin.jobConnect.POJOs.Task;
import com.nitin.jobConnect.Reporsitory.TaskRepo;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired(required = true)
	TaskRepo taskRepo;

	@Override
	public Task createNewTask(Task task) {
		return taskRepo.save(task);
	}
	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}
	@Override
	public ResponseEntity<Task> findTaskById(@PathVariable Long id) {
		Optional<Task> findTaskById = taskRepo.findById(id);
		Task task = findTaskById.get();
		return new ResponseEntity<>(task,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Task> findByTaskName(String taskName) {
//		Optional<Task> findTaskByName = taskRepo.findById(id);
//		Task task = findTaskBy.get();
//		return new ResponseEntity<>(task,HttpStatus.OK);
		return null;
	}

	public void deleteTask(Task task) {
		taskRepo.delete(task);
	}

	public void deleteTaskById(Long id) {
		taskRepo.deleteById(id);
	}

	public Task updateTask(Task task) {
		return taskRepo.save(task);
	}
	
	@Override
	public List<Task> findAllCompletedTask() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> findInCompleteTask() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

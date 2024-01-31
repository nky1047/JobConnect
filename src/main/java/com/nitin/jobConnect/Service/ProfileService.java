package com.nitin.jobConnect.Service;

import java.util.ArrayList;
import java.util.List;

import com.nitin.jobConnect.POJOs.Profiles;
import com.nitin.jobConnect.POJOs.Task;

public interface ProfileService {
	List<Profiles> searchProfileByText(String text);
	
//	 List<Task> findAllTaskByProfile();
	
}

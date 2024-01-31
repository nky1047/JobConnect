package com.nitin.jobConnect.Reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitin.jobConnect.POJOs.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}

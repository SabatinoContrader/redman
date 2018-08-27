package com.contrader.redman.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contrader.redman.dao.TaskRepository;
import com.contrader.redman.model.Task;

import java.util.List;

@Service
public class TaskService {
	private TaskRepository taskRepository;

	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	public List<Task> findAll() {
       return (List<Task>) taskRepository.findAll();
    }
}

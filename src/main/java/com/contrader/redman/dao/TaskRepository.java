package com.contrader.redman.dao;

import com.contrader.redman.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findByIdtask(int idtask);
}

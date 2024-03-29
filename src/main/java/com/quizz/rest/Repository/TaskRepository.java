package com.quizz.rest.Repository;

import com.quizz.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}

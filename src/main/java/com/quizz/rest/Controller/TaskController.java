package com.quizz.rest.Controller;

import com.quizz.rest.Model.Task;
import com.quizz.rest.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/getTasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/savetask")
    public String saveTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return "Task saved!";
    }

    @PutMapping("/updateTask/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return "Task updated!";
    }

    @DeleteMapping("/deletetask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted!";
    }

    @PutMapping("/updatetask/{id}/tag/{tagId}")
    public Task addTagToTask(@PathVariable Long id, @PathVariable Long tagId) {
        return taskService.addTagToTask(id, tagId);
    }
}

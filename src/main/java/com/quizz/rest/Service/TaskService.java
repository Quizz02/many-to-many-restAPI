package com.quizz.rest.Service;

import com.quizz.rest.Model.Tag;
import com.quizz.rest.Model.Task;
import com.quizz.rest.Repository.TagRepository;
import com.quizz.rest.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TagRepository tagRepository;

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public void updateTask(Long id, Task task) {
        Task updatedTask = taskRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.getStatus());
        taskRepository.save(updatedTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task addTagToTask(Long id, Long tagId) {
        Set<Tag> tagsSet = null;
        Task task = taskRepository.findById(id).get();
        Tag tag = tagRepository.findById(tagId).get();
        tagsSet = task.getTags();
        tagsSet.add(tag);
        task.setTags(tagsSet);
        return taskRepository.save(task);
    }
}

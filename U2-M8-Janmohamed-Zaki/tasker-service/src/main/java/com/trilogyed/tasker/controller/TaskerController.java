package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.viewmodel.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/tasks")
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

//getById
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel fetchItem(@PathVariable("id") int task_id){
        TaskViewModel task = service.fetchTask(task_id);
        if (task == null)
            throw new NotFoundException("No task found for id " + task_id);
        return task;
    }

//getAll
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks(){
        List<TaskViewModel> taskViewModel = service.fetchAllTasks();
        return taskViewModel;
    }

//getByCategory
    @GetMapping("category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTaskByCategory(@PathVariable("category") String category){
        List<TaskViewModel> taskViewModel =service.fetchTasksByCategory(category);
        return taskViewModel;
    }

//new
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel createNewTask(@RequestBody @Valid TaskViewModel task){
        return service.newTask(task);
    }

//update
    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem (@PathVariable("id")int task_id, @RequestBody @Valid TaskViewModel taskViewModel){
        if( taskViewModel.getTaskId() == 0)
            taskViewModel.setTaskId(task_id);
        if (task_id != taskViewModel.getTaskId()){
            throw new IllegalArgumentException("Provided task ID does not match any records.");
        }
        service.updateTask(taskViewModel);
    }

//delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}

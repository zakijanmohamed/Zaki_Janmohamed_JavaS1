package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.feign.AdServerService;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.viewmodel.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    private final AdServerService adServerService;

    TaskerDao dao;

    @Autowired
    public TaskerServiceLayer(TaskerDao taskerDao,AdServerService adServerService){
        this.adServerService = adServerService;
        this.dao = taskerDao;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setTaskId(task.getTaskId());
        tvm.setDescription(task.getTaskDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        tvm.setAdvertisement(adServerService.getAd());

        return tvm;

    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task>tasksList = dao.getAllTasks();
        List<TaskViewModel> taskViewModels = new ArrayList<>();

        for(Task task: tasksList){
            taskViewModels.add(buildTVM(task));
        }
        return taskViewModels;

    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task>tasksList = dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModels = new ArrayList<>();

        for(Task task: tasksList){
            taskViewModels.add(buildTVM(task));
        }
        return taskViewModels;
    }

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setTaskDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setTaskId(task.getTaskId());


        taskViewModel.setAdvertisement(adServerService.getAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);
    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setTaskId(taskViewModel.getTaskId());
        task.setTaskDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        dao.updateTask(task);

        taskViewModel.setAdvertisement(adServerService.getAd());
    }

    private TaskViewModel buildTVM(Task task){
        TaskViewModel taskViewModel = new TaskViewModel();

        taskViewModel.setTaskId(task.getTaskId());
        taskViewModel.setDescription(taskViewModel.getDescription());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setAdvertisement(adServerService.getAd());

        return taskViewModel;
    }

}

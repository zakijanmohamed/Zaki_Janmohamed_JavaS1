package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.viewmodel.TaskViewModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class TaskerServiceLayerTest {


    TaskerDao taskerDao;
    TaskerServiceLayer taskerServiceLayer;

    @Before
    public void setUp() throws Exception{

        setUpTaskerDaoMock();

//        taskerServiceLayer = new TaskerServiceLayer(taskerDao);
    }

    private void setUpTaskerDaoMock(){

        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setTaskId(2);
        task.setTaskDescription("this is a task");
        task.setCreateDate(LocalDate.of(2020,04,16));
        task.setDueDate(LocalDate.of(2020,04,20));
        task.setCategory("A");

        Task task1 = new Task();
        task1.setTaskId(3);
        task1.setTaskDescription("this is another task");
        task1.setCreateDate(LocalDate.of(2020,04,16));
        task1.setDueDate(LocalDate.of(2020,05,20));
        task1.setCategory("B");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(2);
        doReturn(taskList).when(taskerDao).getAllTasks();

    }

    @Test //adds, gets, deletes
    public void shouldCreateAndFetch(){

        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setDescription("this is another task");
        taskViewModel.setCreateDate(LocalDate.of(2020,04,16));
        taskViewModel.setDueDate(LocalDate.of(2020,05,20));
        taskViewModel.setCategory("B");
        taskViewModel.setAdvertisement(taskViewModel.getAdvertisement());

        taskViewModel = taskerServiceLayer.newTask(taskViewModel);

        TaskViewModel tvm = taskerServiceLayer.fetchTask(taskViewModel.getTaskId());
        assertEquals(taskViewModel,tvm);

    }

    @Test //gets all
    public void ShouldGetAllTasks(){

        Task task = new Task();
        task.setTaskId(2);
        task.setTaskDescription("this is a task");
        task.setCreateDate(LocalDate.of(2020,04,16));
        task.setDueDate(LocalDate.of(2020,04,20));
        task.setCategory("A");

        Task task1 = new Task();
        task1.setTaskId(3);
        task1.setTaskDescription("this is another task");
        task1.setCreateDate(LocalDate.of(2020,04,16));
        task1.setDueDate(LocalDate.of(2020,05,20));
        task1.setCategory("B");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        taskList.add(task1);

        doReturn(taskList).when(taskerDao).getAllTasks();


    }

//    @Test//gets by category
//    public void ShouldGetByCategory(){
//        Task task = new Task();
//        task.setTaskId(2);
//        task.setTaskDescription("this is a task");
//        task.setCreateDate(LocalDate.of(2020,04,16));
//        task.setDueDate(LocalDate.of(2020,04,20));
//        task.setCategory("A");
//
//        Task task1 = new Task();
//        task1.setTaskId(3);
//        task1.setTaskDescription("this is another task");
//        task1.setCreateDate(LocalDate.of(2020,04,16));
//        task1.setDueDate(LocalDate.of(2020,05,20));
//        task1.setCategory("B");
//
//        Task task2 = new Task();
//        task2.setTaskId(3);
//        task2.setTaskDescription("this is another task");
//        task2.setCreateDate(LocalDate.of(2020,04,16));
//        task2.setDueDate(LocalDate.of(2020,05,20));
//        task2.setCategory("B");
//
//        List<Task> taskList = new ArrayList<>();
//        taskList.add(task1);
//        taskList.add(task2);
//
//        doReturn(taskList).when(taskerDao).getTasksByCategory();
//
//    }


}


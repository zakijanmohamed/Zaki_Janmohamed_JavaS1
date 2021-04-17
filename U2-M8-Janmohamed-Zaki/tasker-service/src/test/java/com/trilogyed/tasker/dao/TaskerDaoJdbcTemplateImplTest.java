package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    private Task task;

    @Before
    public void setUp() throws Exception {
        clearDatabase();
        setUpTestObjects();
    }

    public void clearDatabase(){
        List<Task> taskList = taskerDao.getAllTasks();
        for (Task tasks : taskList){
            taskerDao.deleteTask(tasks.getTaskId());
        }
    }

    public void setUpTestObjects() {

        task = new Task();
        task.setTaskDescription("This is a task.");
        task.setCreateDate(LocalDate.of(2021,02,05));
        task.setDueDate(LocalDate.of(2021,02,07));
        task.setCategory("A");

    }

    @Test
    public void createGetDeleteTask() {

        task = taskerDao.createTask(task);

        Task task1 =taskerDao.getTask(task.getTaskId());
        assertEquals(task1,task);

        taskerDao.deleteTask(task.getTaskId());
    }


    @Test
    public void getAllTasks() {

        task = taskerDao.createTask(task);

        task = new Task();
        task.setTaskDescription("This is another task.");
        task.setCreateDate(LocalDate.of(2019,02,05));
        task.setDueDate(LocalDate.of(2020,02,07));
        task.setCategory("B");
        taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getAllTasks();
        assertEquals(2,taskList.size());
    }

    @Test
    public void getTasksByCategory() {

        task = taskerDao.createTask(task);

        task = new Task();
        task.setTaskDescription("This is another task.");
        task.setCreateDate(LocalDate.of(2019,02,05));
        task.setDueDate(LocalDate.of(2020,02,07));
        task.setCategory("C");
        taskerDao.createTask(task);

        List<Task> taskList = taskerDao.getTasksByCategory("C");
        assertEquals(1,taskList.size());

        taskList =taskerDao.getTasksByCategory("A");
        assertEquals(1,taskList.size());
    }

    @Test
    public void updateTask() {

        task = taskerDao.createTask(task);

        task.setTaskDescription("This is another task.");
        task.setCreateDate(LocalDate.of(2019,02,05));
        task.setDueDate(LocalDate.of(2020,02,07));
        task.setCategory("C");
        taskerDao.updateTask(task);

        Task task1 = taskerDao.getTask(task.getTaskId());
        assertEquals(task1,task);

    }


}
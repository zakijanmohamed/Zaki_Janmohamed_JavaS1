package com.trilogyed.tasker.viewmodel;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class TaskViewModel {

    @NotNull
    private int taskId;
    @NotEmpty(message = "You must supply a task description")
    @Size(max = 255, message = "Description must be 255 characters or less")
    private String description;
    @NotNull
    @FutureOrPresent(message = "due date must be the present date in YYY/MM/DD format")
    private LocalDate createDate;
    @NotNull
    @Future(message = "due date must be a future date in YYYY/MM/DD format")
    private LocalDate dueDate;
    @NotEmpty(message = "You must supply a task category")
    @Size(max = 50, message = "Category must be 50 characters or less.")
    private String category;
    private String advertisement;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskViewModel)) return false;
        TaskViewModel that = (TaskViewModel) o;
        return taskId == that.taskId && Objects.equals(description, that.description) && Objects.equals(createDate, that.createDate) && Objects.equals(dueDate, that.dueDate) && Objects.equals(category, that.category) && Objects.equals(advertisement, that.advertisement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, description, createDate, dueDate, category, advertisement);
    }

    @Override
    public String toString() {
        return "TaskViewModel{" +
                "id=" + taskId +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", category='" + category + '\'' +
                ", advertisement='" + advertisement + '\'' +
                '}';
    }
}

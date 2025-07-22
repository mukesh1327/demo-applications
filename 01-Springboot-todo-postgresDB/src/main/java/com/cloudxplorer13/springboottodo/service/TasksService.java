package com.cloudxplorer13.springboottodo.service;

import java.util.List;

import com.cloudxplorer13.springboottodo.controller.wrapper.TaskResponse;
import com.cloudxplorer13.springboottodo.model.dto.TasksDto;
import com.cloudxplorer13.springboottodo.model.entity.Tasks;

public interface TasksService {
    TasksDto convertToDTO(Tasks task);
    TaskResponse createTask(TasksDto taskDTO);
    TaskResponse getTaskById(Integer taskId);
    TasksDto updateTask(Integer taskId, TasksDto taskDTO);
    void deleteTask(Integer taskId);
    List<TasksDto> getAllTasks();
}

package com.noventiqvaluepoint.springboottodo.service;

import java.util.List;

import com.noventiqvaluepoint.springboottodo.controller.wrapper.TaskResponse;
import com.noventiqvaluepoint.springboottodo.model.dto.TasksDto;
import com.noventiqvaluepoint.springboottodo.model.entity.Tasks;

public interface TasksService {
    TasksDto convertToDTO(Tasks task);
    TaskResponse createTask(TasksDto taskDTO);
    TaskResponse getTaskById(Integer taskId);
    TasksDto updateTask(Integer taskId, TasksDto taskDTO);
    void deleteTask(Integer taskId);
    List<TasksDto> getAllTasks();
}

package com.cloudxplorer13.springboottodo.model.mapper;

// import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.cloudxplorer13.springboottodo.model.dto.TasksDto;
import com.cloudxplorer13.springboottodo.model.entity.Tasks;

public interface TasksMapper {

    TasksMapper INSTANCE = Mappers.getMapper(TasksMapper.class);

    // @Mapping(target = "createdAt", ignore = true)
    // @Mapping(target = "updatedAt", ignore = true)
    TasksDto entityToDTO(Tasks task);
}

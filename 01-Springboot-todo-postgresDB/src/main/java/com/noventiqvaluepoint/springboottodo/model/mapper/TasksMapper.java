package com.noventiqvaluepoint.springboottodo.model.mapper;

// import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import com.noventiqvaluepoint.springboottodo.model.dto.TasksDto;
import com.noventiqvaluepoint.springboottodo.model.entity.Tasks;

public interface TasksMapper {

    TasksMapper INSTANCE = Mappers.getMapper(TasksMapper.class);

    // @Mapping(target = "createdAt", ignore = true)
    // @Mapping(target = "updatedAt", ignore = true)
    TasksDto entityToDTO(Tasks task);
}

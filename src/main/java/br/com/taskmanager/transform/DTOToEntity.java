package br.com.taskmanager.transform;

import br.com.taskmanager.dto.TaskDTO;
import br.com.taskmanager.entities.Task;

public class DTOToEntity {

    public Task transformDtoToEntity(TaskDTO dto){

        Task task = Task.builder()
                            .WithName(dto.getName())
                            .WithDescription(dto.getDescription())
                            .WithTaskType(dto.getTaskType())
                            .WithInitialDate(dto.getInitialDate())
                            .WithLimiteDate(dto.getLimiteDate())
                            .WithDateRegister(dto.getDateRegister())
                            .build();
        return task;
    }
}

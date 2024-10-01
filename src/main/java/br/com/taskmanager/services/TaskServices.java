package br.com.taskmanager.services;

import java.sql.Date;
import java.util.List;

import br.com.taskmanager.dto.TaskDTO;
import br.com.taskmanager.entities.Task;
import br.com.taskmanager.persistence.PersistTask;
import br.com.taskmanager.repositories.TaskRepository;
import br.com.taskmanager.transform.DTOToEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TaskServices {

    @Inject
    PersistTask persist;

    @Inject
    DTOToEntity transform;

    @Inject
    TaskRepository repository;

    public Task persistTask(TaskDTO dto){
        Date currentDate = new Date(0);
        dto.setDateRegister(currentDate);
        Task registerTask = transform.transformDtoToEntity(dto);
        return persist.persistTask(registerTask);
    }

    public Task getTaskByName(String name){
        Task taskByName = this.repository.getByName(name);
        return taskByName;
    }

    public Task getTaskById(String id){
        Task taskById = this.repository.getById(id);
        return taskById;
    }

    public List< Task > getByRegisterDate(Date date){
        List< Task > tasksByRegisterDate = this.repository.getByDate(date);
        return tasksByRegisterDate;
    }

    public List< Task > getByInitialDate(Date date){
        List< Task > tasksByInitialDate = this.repository.getByDateInitial(date);
        return tasksByInitialDate;
    }

    public List< Task > getByLimiteDate(Date date){
        List< Task > tasksByLimiteDate = this.repository.getByDateLimite(date);
        return tasksByLimiteDate;
    }

    public List< Task > getEveryTasks(){
        return this.repository.getEveryTasks();
    }
}

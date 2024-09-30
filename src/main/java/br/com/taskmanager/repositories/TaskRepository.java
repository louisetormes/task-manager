package br.com.taskmanager.repositories;

import java.util.Date;
import java.util.List;

import br.com.taskmanager.entities.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class TaskRepository implements PanacheRepository<Task>{

    public Task getByName(String name){
        return find("?1 = task_name", name)
        .firstResult();
    }

    public Task getById(String id){
        return find("?1 = id", id)
        .firstResult();
    }

    public List< Task > getByDate(Date date){
        return find("?1 = date_register", date)
        .list();
    }

    public List< Task > getByDateInitial(Date date){
        return find("?1 = initial_date", date)
        .list();
    }

    public List< Task > getByDateLimite(Date date){
        return find("?1 = limite_date", date)
        .list();
    }

    public List< Task > getEveryTasks(){
        return listAll();
    }
}

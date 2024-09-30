package br.com.taskmanager.persistence;

import br.com.taskmanager.entities.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersistTask implements PanacheRepository<Task> {

    public Task persistTask(Task task){
        persist(task);
        return task;
    }
}

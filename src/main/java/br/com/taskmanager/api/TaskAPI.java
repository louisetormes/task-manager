package br.com.taskmanager.api;

import java.util.List;

import br.com.taskmanager.dto.TaskDTO;
import br.com.taskmanager.entities.Task;
import br.com.taskmanager.services.TaskServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/task")
@ApplicationScoped
public class TaskAPI {

    @Inject
    TaskServices taskService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(TaskDTO body){
        Task task = taskService.persistTask(body);
        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Task getByName(@PathParam("name") String name){
        Task task = taskService.getTaskByName(name);
        return task;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Task getById(@PathParam("id") String id){
        Task task = taskService.getTaskById(id);
        return task;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List< Task > getAllTasks(){
        List< Task > all = taskService.getEveryTasks();
        return all;
    }
}

package br.com.taskmanager.dto;

import java.io.Serializable;
import java.util.Date;


import br.com.taskmanager.enums.TaskType;
import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO implements Serializable{

    @JsonbProperty("taskName")
    private String name;
    @JsonbProperty("taskDescription")
	private String description;
    @JsonbProperty("taskInitialDate")
	private Date initialDate;
    @JsonbProperty("taskLimiteDate")
	private Date limiteDate;
    @JsonbProperty("taskType")
	private TaskType taskType;
    private Date dateRegister;
}

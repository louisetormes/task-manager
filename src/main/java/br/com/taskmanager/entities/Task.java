package br.com.taskmanager.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.taskmanager.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Table(name = "task")
@Builder(setterPrefix = "With")
@AllArgsConstructor
public class Task {

	@Id
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "UUIDGenerator")
	@Column(name = "id")
	private UUID id;

	@Column(name = "task_name")
	private String name;

	@Column(name = "task_description")
	private String description;

	@Column(name = "initial_date")
	private Date initialDate;

	@Column(name = "limite_date")
	private Date limiteDate;

	@Column(name = "date_register")
	private Date dateRegister;

	@Column(name = "task_type")
	private TaskType taskType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getLimiteDate() {
		return limiteDate;
	}

	public void setLimiteDate(Date limiteDate) {
		this.limiteDate = limiteDate;
	}

	public Date getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(Date dateRegister) {
		this.dateRegister = dateRegister;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
}

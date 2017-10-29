package com.durgadas.springboot.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Topic {
	@Id
	@ApiModelProperty(notes="ID for the topic")
	private String id;
	
	@ApiModelProperty(notes="Name of the topic")
	@NotEmpty
	private String name;
	
	@ApiModelProperty(notes="Description for the topic")
	private String description;
	
	public Topic() {
	}
	

	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	

}

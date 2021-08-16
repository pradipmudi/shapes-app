package com.pradip.vm.shape.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Model {
	@Id
	long taskId;
	String jsonData;
	
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	
	
}

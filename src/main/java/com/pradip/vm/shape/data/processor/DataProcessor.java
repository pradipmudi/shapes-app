package com.pradip.vm.shape.data.processor;

import java.util.Iterator;
import java.util.Optional;

import org.json.JSONObject;

import com.pradip.vm.shape.model.Model;
import com.pradip.vm.shape.repository.ShapeRepository;

public class DataProcessor {
	static DataProcessor dataProcessor;
	ShapeRepository shapeRepository;
	
	private DataProcessor() {
		// TODO Auto-generated constructor stub
	}

	public static DataProcessor getInstance() {
		if(dataProcessor == null) {
			synchronized (DataProcessor.class) {
				if(dataProcessor == null) {
					dataProcessor = new DataProcessor();
				}
			}
		}
		return dataProcessor;
	}

	public boolean parseAndProcess(String jsonData) {
		try {			
			JSONObject jsonObject = new JSONObject(jsonData.trim());
			Iterator<String> keys = jsonObject.keys();
			
			while(keys.hasNext()) {
				String key = keys.next();
				if (jsonObject.get(key) instanceof JSONObject) {
					System.out.println(jsonObject.get(key).toString());     
					Model shapeTask = new Model();
					shapeTask.setTaskId(Long.valueOf(key));
					shapeTask.setJsonData(jsonObject.get(key).toString());
					System.out.println(shapeTask.toString());
					//shapeRepository.save(shapeTask);
				}
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public String getResult(long type) {
		Optional<Model> shapeTask = shapeRepository.findById(type);
		System.out.println(shapeTask.toString());
		return shapeTask.toString();
	}

}

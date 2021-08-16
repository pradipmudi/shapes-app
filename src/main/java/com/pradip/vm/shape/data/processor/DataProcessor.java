package com.pradip.vm.shape.data.processor;

import java.util.Iterator;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pradip.vm.shape.bo.interfaces.Shape;
import com.pradip.vm.shape.model.Model;
import com.pradip.vm.shape.repository.ShapeRepository;
import com.pradip.vm.shape.util.ShapeParserUtil;

@Service
public class DataProcessor {
	
	@Autowired
	ShapeRepository shapeRepository;


	public boolean parseAndProcess(String jsonData) {
		try {			
			JSONObject jsonObject = new JSONObject(jsonData.trim());
			Iterator<String> keys = jsonObject.keys();
			
			while(keys.hasNext()) {
				String key = keys.next();
				if (jsonObject.get(key) instanceof JSONObject) {
					Model shapeTask = new Model();
					shapeTask.setTaskId(Long.valueOf(key));
					shapeTask.setJsonData(jsonObject.get(key).toString());
					shapeRepository.save(shapeTask);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getResult(long type) {
		Optional<Model> shape = shapeRepository.findById(type);
		if(shape.isPresent()) {
			
			Model model = shape.get();
			
			
			String shapeTask = shape.get().toString();
			
			try {
				Shape shpObj = ShapeParserUtil.findShape(model);
				
				return "{\""+type+"\" : "+String.format("%.2f", shpObj.area())+"}";
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			return shapeTask;
		}
		
		return "No Data found for this task..";
	}

}

package com.pradip.vm.shape.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pradip.vm.shape.data.processor.DataProcessor;

@RestController
public class ShapeController {
	
	@PostMapping("/insert")
	boolean insertData(@RequestBody(required = true) String jsonData) {
		return DataProcessor.getInstance().parseAndProcess(jsonData);
	}
	
	@GetMapping("/result/{type}")
	String getTaskData(@PathVariable(value="type") long type){
		return DataProcessor.getInstance().getResult(type);
	}
}

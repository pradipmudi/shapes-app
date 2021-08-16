package com.pradip.vm.shape.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradip.vm.shape.bo.CircleBO;
import com.pradip.vm.shape.bo.RectangleBO;
import com.pradip.vm.shape.bo.SquareBO;
import com.pradip.vm.shape.bo.interfaces.Shape;
import com.pradip.vm.shape.model.Model;

public class ShapeParserUtil {

	
	public static Shape findShape(Model model) throws JsonMappingException, JsonProcessingException {
		
		Shape shape = null;
		
		String jsonData = model.getJsonData();
		
		ObjectMapper mapper = new ObjectMapper();
		
		if(jsonData.contains("circle")) {
			
			CircleBO circle = mapper.readValue(jsonData, CircleBO.class);
			shape = circle;
		}else if(jsonData.contains("square")) {
			
			SquareBO square = mapper.readValue(jsonData, SquareBO.class);
			shape = square;
		}else if(jsonData.contains("rectangle")) {
			
			RectangleBO rectangle = mapper.readValue(jsonData, RectangleBO.class);
			shape = rectangle;
		}
		
		return shape;
	}
}

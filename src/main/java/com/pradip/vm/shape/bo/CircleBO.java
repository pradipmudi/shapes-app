package com.pradip.vm.shape.bo;

import com.pradip.vm.shape.bo.interfaces.Shape;

public class CircleBO implements Shape{
	
	String type;
	double radius;
	
	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}



	@Override
	public double area() {
		return Math.PI*radius*radius;
	}



	@Override
	public String toString() {
		return "CircleBO [type=" + type + ", radius=" + radius + "]";
	}
	
	

}

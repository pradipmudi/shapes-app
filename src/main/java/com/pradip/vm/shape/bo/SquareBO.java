package com.pradip.vm.shape.bo;

import com.pradip.vm.shape.bo.interfaces.Shape;

public class SquareBO implements Shape{
	
	String type;
	double side;
	
	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public double getSide() {
		return side;
	}



	public void setSide(double side) {
		this.side = side;
	}



	@Override
	public double area() {
		return side*side;
	}



	@Override
	public String toString() {
		return "SquareBO [type=" + type + ", side=" + side + "]";
	}

	
}

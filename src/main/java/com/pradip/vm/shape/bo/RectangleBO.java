package com.pradip.vm.shape.bo;

import com.pradip.vm.shape.bo.interfaces.Shape;

public class RectangleBO implements Shape{
	
	String type;
	double l;
	double b;
	
	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public double getL() {
		return l;
	}



	public void setL(double l) {
		this.l = l;
	}



	public double getB() {
		return b;
	}



	public void setB(double b) {
		this.b = b;
	}



	@Override
	public double area() {
		return l*b;
	}



	@Override
	public String toString() {
		return "RectangleBO [type=" + type + ", l=" + l + ", b=" + b + "]";
	}
	
	

}

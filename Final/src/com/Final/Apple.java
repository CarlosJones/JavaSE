package com.Final;

public class Apple {
	private float weight;
	
	public Apple(float weight){
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public void print(){
		System.out.println("Weight is "+String.valueOf(weight));
	}
	
	public void printHashCode(){
		System.out.println("HashCode: "+String.valueOf(hashCode()));
	}
}

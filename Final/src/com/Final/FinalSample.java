package com.Final;

/**
 * final对于引用类型变量“只能保证指向不变，却不能保证指向的对象本身不变”
 * @author CarlosJones
 */
public class FinalSample {
	public static void main(String[] args) {
		final Apple apple = new Apple(30f);
		apple.print();
		apple.printHashCode();
		apple.setWeight(3f);
		apple.print();
		apple.printHashCode();
	}
}

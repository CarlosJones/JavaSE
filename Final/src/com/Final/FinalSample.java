package com.Final;

/**
 * final�����������ͱ�����ֻ�ܱ�ָ֤�򲻱䣬ȴ���ܱ�ָ֤��Ķ������䡱
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

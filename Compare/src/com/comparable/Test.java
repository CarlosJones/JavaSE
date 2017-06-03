package com.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author CarlosJones
 * 
 */
public class Test {
	public static final Comparator<User> Comparator = new Comparator<User>(){
		@Override
		public int compare(User o1, User o2) {
			return o1.compareTo(o2);
		}
	};	
	
	public static void main(String[] args) {
		ArrayList<User> students = new ArrayList<User>();
		User user1 = new User(1,"yueliming");
        User user2 = new User(2,"yueliming");
        students.add(user1);
        students.add(user2);
        Collections.sort(students,Comparator);
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i).getId());
        }
	}
}

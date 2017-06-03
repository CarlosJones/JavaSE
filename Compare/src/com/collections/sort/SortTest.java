package com.collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author CarlosJones
 * 
 */
public class SortTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("5");
		list.add("2");
		list.add("9");
		// list中的对象String 本身含有compareTo方法，所以可以直接调用sort方法，按自然顺序排序，即升序排序
		Collections.sort(list);
		Iterator<String> it = list.iterator();
		// List<A> list = new ArrayList<A>();
		// A aa = new A();
		// aa.setName("aa");
		// aa.setOrder(1);
		// A bb = new A();
		// bb.setName("bb");
		// bb.setOrder(2);
		// list.add(bb);
		// list.add(aa);
		// // list中的对象A实现Comparable接口
		// Collections.sort(list);
		// Iterator<A> it = list.iterator();

		// List<B> listB = new ArrayList<B>();
		// B ab = new B();
		// ab.setName("ab");
		// ab.setOrder("1");
		// B ba = new B();
		// ba.setName("ba");
		// ba.setOrder("2");
		// listB.add(ba);
		// listB.add(ab);
		// Collections.sort(listB,new Comparator<B>(){
		// @Override
		// public int compare(B b, B b2) {
		// return b.getOrder().compareTo(b2.getOrder());
		// }
		//
		// });

		// Iterator<B> it = listB.iterator();
		while (it.hasNext())

		{
			System.out.println(it.next());
		}

		// System.out.println(aa.compareTo(bb));
		// System.out.println(bb.compareTo(bb));
		// System.out.println(bb.compareTo(aa));
	}
}

class A implements Comparable<A> {
	private String name;
	private Integer order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public int compareTo(A o) {
		return this.getOrder().compareTo(o.getOrder());
	}
}

class B {
	private String name;
	private String order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String string) {
		this.order = string;
	}

	public String toString() {
		return "name is " + name + " order is " + order;
	}
}
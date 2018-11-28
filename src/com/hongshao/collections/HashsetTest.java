package com.hongshao.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashsetTest {
	
	
	
	public static void main(String[] args) {
		
		/**
		 * HashSet<Number>
		 */
//		HashSet<Number> set = new HashSet<Number>();
//		set.add(0);
//		set.add(1);
//		set.add(0);
//		set.add(2);
//		set.add(3);
//		set.add(4);
//		
//		for(Number no:set) {
//			System.out.println(no);
//		}
//		
//		Iterator<Number> it = set.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
//		
//		for(Iterator<Number> it1 = set.iterator();it1.hasNext();) {
//			System.out.println(it1.next());
//		}
		
		/**
		 * HashSet<String>
		 */
//		HashSet<String> set = new HashSet<String>();
//		
//		String s1 = new String("hongshao");
//		String s4 = new String("hongshao");
//		String s2 = "hongshao";
//		String s3 = "hongshao";
//		System.out.println(s1.equals(s2));
//		set.add("hongshao");
//		set.add("curry");
//		set.add(s1);
//		set.add(s2);
//
//		for(String str:set) {
//			System.out.println(str);
//		}
		
		
		/**
		 * HashSet<Object>
		 */
		ObjectWithOutHashCode obj1 = new ObjectWithOutHashCode("curry");
		ObjectWithOutHashCode obj2 = new ObjectWithOutHashCode("curry");
		
		Set set = new HashSet<>();
		set.add(obj1);
		set.add(obj2);
		set.add(null);
		set.add(null);
		set.add("hongshao");
		set.add(1);
		
		for(Object no:set) {
//			System.out.println(!(no==null)?no.name:no);
			System.out.println(no);
		}
		
		
//		LinkedHashSet<Student> st = new LinkedHashSet<Student>();
//		Student st1 = new Student("hongshao",22);
//		Student st2 = new Student("hongshao",23);
//		Student st3 = new Student("hongshao",22);
//		Student st4 = new Student("hs2",11);
//		
//		st.addAll(Arrays.asList(st1,st2,st3,st4));
//		
//		for(Student student:st) {
//			System.out.println(student);
//		}
		
	}
}

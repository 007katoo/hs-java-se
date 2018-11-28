package com.hongshao.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	
//	public static void main(String[] args) {
//		TreeSet<Student> ts = new TreeSet<Student>();
//		
//		Student st1 = new Student("hongshao",21);
//		Student st2 = new Student("hongshao",23);
//		Student st3 = new Student("hongshao",23);
//		Student st4 = new Student("hs2",11);
//		
//		ts.addAll(Arrays.asList(st1,st2,st3,st4));
//		
//		for(Student student:ts) {
//			System.out.println(student);
//		}
//	}
	
	public static void main(String[] args) {
	      test2();
	 }
	
    /**
     * 自然排序
     */
    public static void test1() {
        Employee e1 = new Employee("liudehua",55,new MyDate(4,12,1997));
        Employee e2 = new Employee("11",55,new MyDate(5,12,1997));
        Employee e3 = new Employee("22",55,new MyDate(6,12,1997));
        Employee e4 = new Employee("33",55,new MyDate(7,12,1997));
        Employee e5 = new Employee("44",55,new MyDate(8,12,1997));
        TreeSet set = new TreeSet();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
    
    /**
     * 定制排序
     */
    public static void test2() {
        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;

                    MyDate birth1 = e1.getBirthday();
                    MyDate birth2 = e2.getBirthday();

                    if(birth1.getYear() != birth2.getYear()) {
                        return birth1.getYear() - birth2.getYear();
                    } else {
                        if (birth1.getMonth() != birth2.getMonth()) {
                            return birth1.getMonth() - birth2.getMonth();
                        } else {
                            return birth1.getDay() - birth2.getDay();
                        }
                    }
                }
                return 0;
            }
        };

        TreeSet<Employee> set = new TreeSet(comparator);
        Employee e1 = new Employee("liudehua",55,new MyDate(5,8,1990));
        Employee e2 = new Employee("11",55,new MyDate(5,11,1997));
        Employee e3 = new Employee("22",55,new MyDate(6,10,1997));
        Employee e4 = new Employee("33",55,new MyDate(7,9,1997));
        Employee e5 = new Employee("44",55,new MyDate(8,8,1997));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

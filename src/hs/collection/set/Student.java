package hs.collection.set;

public class Student implements Comparable<Student>{
	
	public String name;
	
	public int age;

	public Student(String name,int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}


	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if (arg0 instanceof Student) {
			Student st = (Student)arg0;
			return name.equals(st.name);			
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode();
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}
}

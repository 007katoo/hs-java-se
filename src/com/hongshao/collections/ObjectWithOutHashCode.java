package com.hongshao.collections;

public class ObjectWithOutHashCode {
		
	public String name;
	
	public ObjectWithOutHashCode(String name) {
		super();
		this.name = name;
	}

	public int hashCode() {
		return this.name.hashCode();
	};
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		if (obj instanceof ObjectWithOutHashCode) {
//			ObjectWithOutHashCode obj1 = (ObjectWithOutHashCode) obj;
//			return this.name.equals(obj1.name);
//		} else {
//			return false;
//		}
		return false;
	}
}

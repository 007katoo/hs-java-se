package com.hongshao.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		Object value = new Object();
		HashMap<String, Object> hashMap = new HashMap<>();
		HashSet<String> hashSet = new HashSet<>();
		LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
		hashSet.add("java");
		hashMap.put("java", value);
		linkedHashSet.add("java");
		linkedHashMap.put("java", value);

		hashSet.add("golang");
		hashMap.put("golang", value);
		linkedHashSet.add("golang");
		linkedHashMap.put("golang", value);

		hashSet.add("python");
		hashMap.put("python", value);
		linkedHashSet.add("python");
		linkedHashMap.put("python", value);

		hashSet.add("ruby");
		hashMap.put("ruby", value);
		linkedHashSet.add("ruby");
		linkedHashMap.put("ruby", value);

		hashSet.add("scala");
		hashMap.put("scala", value);
		linkedHashSet.add("scala");
		linkedHashMap.put("scala", value);

		hashSet.add("c");
		hashMap.put("c", value);
		linkedHashSet.add("c");
		linkedHashMap.put("c", value);

		System.out.println("默认插入序：\njava\tgolang\tpython\truby\tscala\tc");

		System.out.println(" \nHashSet:-------------------");
		for (String str : hashSet) {
			System.out.print(str + "\t");
		}

		System.out.println(" \n\nHashMap:-------------------");
		for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
			System.out.print(entry.getKey() + "\t");
		}

		System.out.println(" \n\nLinkedHashSet:-------------------");
		for (String str : linkedHashSet) {
			System.out.print(str + "\t");
		}

		System.out.println(" \n\nLinkedHashMap:-------------------");
		for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
			System.out.print(entry.getKey() + "\t");
		}
	}
}

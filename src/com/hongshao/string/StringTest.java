package com.hongshao.string;

import java.util.Arrays;

public class StringTest {
	
	public static void main(String[] args) {
		String s = "as叼fdbcd字";
		System.out.println(Arrays.toString(s.toCharArray()));
		System.out.println(Arrays.toString(s.getBytes()));
		String s1 = new String(s.getBytes());
		System.out.println(s1);
	}
}

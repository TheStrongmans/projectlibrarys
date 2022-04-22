package com.qq.utils;

import java.io.*;

public class In {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static String next() {
		String s = "";
		try {
			s = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public static void close() {
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

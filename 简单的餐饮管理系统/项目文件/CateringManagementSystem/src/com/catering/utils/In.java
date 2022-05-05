package com.catering.utils;
/**
 * 
 * @author stephen
 *
 */

import java.io.*;
import java.util.StringTokenizer;
/**
 * 读取输入
 * @author stephen
 *
 */
public class In {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	private static StringTokenizer token;
	public static String next() {
		String s;
		try {
			s = new StringTokenizer(reader.readLine()).nextToken();
		} catch (Exception e) {
			return "";
		}
		
		return s;
	}
	public static String nextLine() {
		String s;
		try {
			s = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			s = "";
		}
		return s;
	}
	public static int nextInt() {
		while(true) {
			try {
				return Integer.parseInt(next());
			} catch (Exception e) {
				System.out.println("输入错误，请重新输入");
			}
		}
	}
	
}

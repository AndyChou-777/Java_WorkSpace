package com.example;

import java.io.*;

public class ExceptionMain {
	public static void main(String[] args) {
		
		try {
		System.out.println("Reading from file:" + args[0]);
		} catch(ArrayIndexOutOfBoundsException i) {
			System.err.println(i.getMessage());
		}
		
		try (BufferedReader b = new BufferedReader(new FileReader(args[0]))){
		String s = null;
		while((s = b.readLine()) != null) {
		System.out.println(s);
		}
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
}

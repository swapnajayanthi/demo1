package com.jayanthi.automation.scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class WriteText {
	@Test
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\jayanthi\\workspace\\Mysampleframework\\src\\com\\jayanthi\\automation\\objectrepository\\html.txt");
		boolean b = file.createNewFile();
		if(b)
		{
			System.out.println("file is created");
		}
		else
		{
			System.out.println("file is already existed");
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("selenium");
		bw.newLine();
		bw.write("java");
		bw.flush();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		br.read();
		while(br.ready())
		{
			String s = br.readLine();
			System.out.println("data entered");
		}
	}

}

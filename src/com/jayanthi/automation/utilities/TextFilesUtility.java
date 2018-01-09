package com.jayanthi.automation.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFilesUtility {
	String filepath;
	FileWriter fw;
	BufferedWriter bw;
	FileReader fr;
	BufferedReader br;
	public TextFilesUtility (String filepath) throws IOException
	{
		this.filepath = filepath;
		File file = new File(filepath);
		file.createNewFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
	}
	public String getData() throws IOException
	{
		String data=null;
		if(data!=null)
		{
			data = br.readLine();
		}
		else
		{
			System.out.println("BR is null....pls cross check");
		}
		return data;
	}
public List<String> getAllData() throws IOException
{
	List<String> data = new ArrayList<String>();
	if(br!=null)
	{
		while(br.ready())
		{
			String data1 = br.readLine();
			data.add(data1);
		}
	}
		else
		{
			System.out.println("BR is null....pls cross check");
		}
		return data;
	}
public void writeData(String data) throws IOException
{
	bw.write(data);
	bw.flush();
}
/*public void writeData(String data) throws IOException
{
	bw.write(data)
	bw.f
	
}*/

public void readData() throws IOException
{
	String data = br.readLine();
	readData();
}
}

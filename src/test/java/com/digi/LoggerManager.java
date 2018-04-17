package com.digi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class LoggerManager {
	public static final LoggerManager logger= new LoggerManager();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	static Date date = new Date();
	private static FileWriter fw;	
	static String  directory=null;
	static File file=null; 
	static PrintWriter pw=null;

	private static String  getFolderName(){
		directory=String.valueOf(date.getDate())+
				String.valueOf(date.getMonth())+
				String.valueOf(date.getYear()).trim();
		return directory; 
	}

	private LoggerManager(){
		
	}
	private static void mkdir(){
		directory=getFolderName();
		file=new File(String.valueOf(directory));
		try {
			if(!file.exists()){
				file.mkdir();
			}
			File file2=new File(directory+"/"+"application");
			fw=new FileWriter(file2,true);
			pw=new PrintWriter(fw);
			logger.info("Logger is initiated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public  static LoggerManager  getLogger(){		
		mkdir();
		logger.info("Logger is initiated");
		return logger;
	}

	private void writeToFile(String message){
		try {
			fw.write(message);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeToFile(String message,Exception e) {
		try {
			fw.write(message);
			e.printStackTrace(pw);
			fw.flush();
		} catch (IOException e1) {
			e.printStackTrace();
		}
	}
	public void cleanup(){
		try {
			logger.info("closing File stream");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public  void info(String message){
		writeToFile("INFO: "+dateFormat.format(date)+" :"+message+"\n");
	}

	public  void info(String className,String message){
		writeToFile("INFO: "+dateFormat.format(date)+" :"+className+" :"+message+"\n");
	}

	public void error(String message,Exception e){
		writeToFile("ERROR: "+dateFormat.format(date)+" :"+message+"\n",e);
	}

	public void error(String className,String message,Exception e){
		writeToFile("ERROR: "+dateFormat.format(date)+" :"+className+" :"+message+"\n",e);
	}

	public void error(String message){
		writeToFile("ERROR: "+dateFormat.format(date)+" :"+message+"\n");
	}

	public void debug(String message){
		writeToFile("DEBUG: "+dateFormat.format(date)+" :"+message);
	}

	public static void main(String[] args){
		LoggerManager tool=LoggerManager.getLogger();
		tool.info("My First Message");
		tool.info("Hello","Second Message");
		File ff=new File("dfd");
		try {
			FileReader f=new FileReader(ff);
		} catch (FileNotFoundException e) {
			tool.error("Testing", "File is not found", e);
		}
		System.out.println("HHHHHH");
	}

}

package com.ashutosh.filemanager;

import java.io.File;
public class FileManager {
	public void listContents(String directoryPath) {
		File directory=new File(directoryPath);
		
		if(directory.exists() && directory.isDirectory()) {
			File[] contents=directory.listFiles();
			
			if(contents!=null) {
				for(File file: contents) {
					if(file.isDirectory()) {
						System.out.println("Dir>>>"+file.getName());
					}
					else {
						System.out.println("File>>>"+file.getName());
					}
				}
			}
			else {
				System.out.println("Empty directory");
			}
		}
		else {
			System.out.println("Path isn't directory or not exist");
		}
	}
	
	public void createDirectory(String directoryPath) {
		
		File directory=new File(directoryPath);
		if(directory.mkdir()) {
			System.out.println("Successfully created directory");
		}
		else {
			System.out.println("failed to create directory");
		}
	}
	
	public void deleteFileOrDirectory(String directoryPath) {
		File file=new File(directoryPath);
		if(file.delete()) {
			System.out.println("Deleted file");
		}
		else {
			System.out.println("failed to delete");
		}
	}
}

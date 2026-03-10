package com.ashutosh.filemanager;

public class FileApp implements UIEventHandler{
	
	private FileManager fm;
	public FileApp() {
		this.fm=new FileManager();
	}
	public static void main(String[] args) {
		UserInterface ui=new TextBasedInter();
		ui.subscribe(new FileApp());
		ui.start();
	}

	@Override
	public void onCreate(String Path) {
		this.fm.createDirectory(Path);;
	}

	@Override
	public void onList(String Path) {
		this.fm.listContents(Path);
	}

	@Override
	public void onDelete(String Path) {
		this.fm.deleteFileOrDirectory(Path);
	}
}

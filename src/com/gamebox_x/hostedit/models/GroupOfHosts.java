package com.gamebox_x.hostedit.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class GroupOfHosts {
	private String name;
	private String filePath;
	private LocalDateTime lastTimeEdit;
	private String localhost = "# Copyright (c) 1993-2009 Microsoft Corp.\n" + 
			"#\n" + 
			"# This is a sample HOSTS file used by Microsoft TCP/IP for Windows.\n" + 
			"#\n" + 
			"# This file contains the mappings of IP addresses to host names. Each\n" + 
			"# entry should be kept on an individual line. The IP address should\n" + 
			"# be placed in the first column followed by the corresponding host name.\n" + 
			"# The IP address and the host name should be separated by at least one\n" + 
			"# space.\n" + 
			"#\n" + 
			"# Additionally, comments (such as these) may be inserted on individual\n" + 
			"# lines or following the machine name denoted by a '#' symbol.\n" + 
			"#\n" + 
			"# For example:\n" + 
			"#\n" + 
			"#      102.54.94.97     rhino.acme.com          # source server\n" + 
			"#       38.25.63.10     x.acme.com              # x client host\n" + 
			"\n" + 
			"# localhost name resolution is handled within DNS itself.\n" + 
			"#	127.0.0.1       localhost\n" + 
			"#	::1             localhost";
	
	private void Initer() {
		OsCheck.OSType os = OsCheck.getOperatingSystemType();
		switch (os) {
		case Windows:
			localhost = localhost.replace("\n", "\r\n");
			break;

		default:
			break;
		}
	}
	
	private void TestForAvailability(String File) {
		if(!new File(File).exists()) {
			try {
				PrintWriter pw = new PrintWriter(new File(File));
				pw.write(localhost);
				pw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public GroupOfHosts() {
		Initer();
		name = "Localhost";
		filePath = ".data/localhost";
		lastTimeEdit = LocalDateTime.parse("1970-01-01T00:00:00");
		TestForAvailability(filePath);
	}
	public GroupOfHosts(String name, String filePath, LocalDateTime lastTimeEdit) {
		Initer();
		this.name = name;
		this.filePath = filePath;
		this.lastTimeEdit = lastTimeEdit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public LocalDateTime getLastTimeEdit() {
		return lastTimeEdit;
	}
	public void setLastTimeEdit(LocalDateTime lastTimeEdit) {
		this.lastTimeEdit = lastTimeEdit;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm");
		return name + " ["+formatter.format(lastTimeEdit)+"]";
	}
	
}

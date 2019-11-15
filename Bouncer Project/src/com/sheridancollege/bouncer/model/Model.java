package com.sheridancollege.bouncer.model;

public class Model {
	
	DataAccess db = null;
	
	public Model() {
		db = new DataAccess(); // crate a new instance
		db.connect();  //  connect to database in Constructor
		
	}
	
	public String imageSelector() {
	
		int i = (int)(Math.random() * 6);
		return "images/"+ i +".jpg";
	}
	
	
	public void registerAccess(String ip) {
		db.insertRow(ip);
		
	}
}
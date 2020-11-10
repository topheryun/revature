package com.app.jdbc.dao.impl;

public class PlayerQueries {
	
	public static final String INSERTPLAYER = "INSERT INTO roc_myrevature.player(id, name, age, gender, teamname, contact) " + 
			"Values(?,?,?,?,?,?)";
	
	public static final String GETPLAYERBYID = "select name, age, gender, teamname, contact from roc_myrevature.player where id=?";

	public static final String INTERNALERRORMESSAGE = "Internal Error Occured. Contact SYSADMIN";
	
}

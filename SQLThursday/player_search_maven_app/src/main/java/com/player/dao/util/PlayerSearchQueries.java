package com.player.dao.util;

public class PlayerSearchQueries {

	public static final String GET_PLAYER_BY_ID = "select  name, age, gender, teamname, contact from roc_myrevature.player where id=?";
	public static final String GET_ALL_PLAYERS = "select id, name, age, gender, teamname, contact from roc_myrevature.player";
	public static final String GET_PLAYERS_BY_GENDER = "select id, name, age, teamname, contact from roc_myrevature.player where gender=?";
	public static final String GET_PLAYERS_BY_NAME = "select id, age, gender, teamname, contact from roc_myrevature.player where name=?";
	public static final String GET_PLAYERS_BY_AGE = "select id, name, gender, teamname, contact from roc_myrevature.player where age=?";
	public static final String GET_PLAYERS_BY_TEAM_NAME = "select id, name, age, gender, contact from roc_myrevature.player where teamname=?";
	public static final String GET_PLAYER_BY_CONTACT = "select id, name, age, gender, teamname from roc_myrevature.player where contact=?";
	
}

package com.player.model;

public class Player {
	
	private int id;
	private String name;
	private String gender;
	private String teamName;
	private long contact;
	private int age;
	
	public Player (int id, String name, int age, String gender, String teamName, long contact) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.teamName = teamName;
		this.contact = contact;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Player() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	@Override
	public String toString() {
		return "Player [id: " + id + ", name: " + name + ", age: " + age + ", gender: " + gender + 
				", teamName: " + teamName + ", contact: " + contact + "]";
	}

}

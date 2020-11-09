package com.bank.model;

public class Log {
	
	private int id;
	private String type;
	private float amount;
	private String ldt;
	
	public Log() {
	}
	
	public Log(int id, String type, float amount, String ldt) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.ldt = ldt;
	}
	
	@Override
	public String toString() {
		String ret = "[" + ldt + "] ";
		if (type.equals("deposit")) {
			ret += "Deposited: $" + amount;
		}
		else if (type.equals("withdraw")) {
			ret += "Withdrew: $" + (amount * -1);
		}
		else if (type.equals("transferTo")) {
			ret += "Transfered: $" + amount;
		}
		else if (type.equals("transferFrom")) {
			ret += "Received: $" + amount;
		}
		return ret;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getLdt() {
		return ldt;
	}
	public void setLdt(String ldt) {
		this.ldt = ldt;
	}
	

}

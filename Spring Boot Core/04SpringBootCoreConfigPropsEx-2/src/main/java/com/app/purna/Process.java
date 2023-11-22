package com.app.purna;

public class Process {
	private int id;
	private String pcode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	@Override
	public String toString() {
		return "Process [id=" + id + ", pcode=" + pcode + "]";
	}
	
	
}

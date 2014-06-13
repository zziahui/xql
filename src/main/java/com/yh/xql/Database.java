package com.yh.xql;

import java.util.List;

public class Database {
	
	private String name;
	
	private String encode;
	
	private	List<Table> tables;

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}
	
	

}

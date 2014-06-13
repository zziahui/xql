package com.yh.xql;

public class SQLContant {
	
	public static String DROPDB = "DROP DATABASE ${dbname} ;";
	
	public static String CREATEDB = "CREATE DATABASE ${dbname} DEFAULT CHARACTER SET DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;";
	
	public static String DROPTB = "DROP TABLE ${tbname} ;";
	
	public static String CREATETB = "CREATE TABLE ${tbname} (";
	
	public static String END = ");";
	public static String Db(String dbname){
		StringBuffer sb = new StringBuffer();
		sb.append(DROPDB);
		sb.append("\n");
		sb.append(CREATEDB);
		sb.append("\n");
		return sb.toString();
	}

}

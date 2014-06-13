package com.yh.xql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;

public class Generate {
	
	public static void Generate(Database database) throws IOException{
		String filename = database.getName();
		String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\sql\\"+filename+".sql";
		File file = new File(filepath);
		if(!file.exists())
			file.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(file);
		String dbname = database.getName();
		StringBuffer sb = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		map.put("dbname", database.getName());
		map.put("dbencode", database.getEncode());
		sb.append(Utils.subReplace(SQLContant.Db(dbname), map));
		for(Table table : database.getTables()){
			//sb.append()
		}
		fos.write(sb.toString().getBytes("UTF-8"));
		fos.flush();
		fos.close();
	}
	
	public static void main(String[] args) throws Exception {
		Xml xml = new Xml();
		Document document = xml.getXmlDocument();
		Database database = xml.analyDocument(document);
		Generate(database);
	}

}


package com.yh.xql;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.google.gson.Gson;

public class Xml {
	
	public Document getXmlDocument() throws Exception{
		SAXReader saxReader = new SAXReader();
		String path = Xml.class.getClassLoader().getResource("table.xml").getPath();
		return saxReader.read(new File(path));
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getAttribute(Element e){
		Map<String, String> map = new HashMap<String, String>();
		List<Attribute> attributes = e.attributes();
		for(Attribute attribute : attributes)
			map.put(attribute.getName(), attribute.getValue());
		return map;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Database analyDocument(Document document){
		Element root = document.getRootElement();
		if(null != root && XmlConstant.DATABASE.equals(root.getName())){
			Database database = new Database();
			Gson gson = new Gson();
			database = gson.fromJson(gson.toJson(getAttribute(root)), Database.class);
			List<Table> tables = new ArrayList<Table>();
			List<Element> elements = root.elements();
			for(Element element : elements){
				Table table = gson.fromJson(gson.toJson(getAttribute(element)), Table.class);
				List<Element> leafs = element.elements();
				List<Column> columns = new ArrayList<Column>();
				for(Element leaf : leafs)
					columns.add(gson.fromJson(gson.toJson(getAttribute(leaf)), Column.class));
				table.setColumns(columns);
				tables.add(table);
			}
			database.setTables(tables);
			return database;
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Xml xml = new Xml();
		Document document = xml.getXmlDocument();
		Database database = xml.analyDocument(document);
		List<Table> tables = database.getTables();
		for(Table table : tables)
			System.out.println(table.getName());
	}

}

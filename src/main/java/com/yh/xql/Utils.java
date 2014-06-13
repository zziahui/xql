package com.yh.xql;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

public class Utils {
	
	public static String subReplace(String templateString, Map<String, String> map){
		StrSubstitutor sub = new StrSubstitutor(map);
		return sub.replace(templateString);
	}
	
	public static void main(String[] args) {
		String templateString = "The ${animal} jumped over the ${target}.";
		Map<String, String> valuesMap = new HashMap<String, String>();
		valuesMap.put("animal", "quick brown fox");
		valuesMap.put("target", "lazy dog");
		System.out.println(Utils.subReplace(templateString, valuesMap));
	}
	

}

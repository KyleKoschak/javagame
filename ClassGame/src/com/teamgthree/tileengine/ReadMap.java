package com.teamgthree.tileengine;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadMap
{
	private String map;
	
	public ReadMap() {
		map = "A1";
	}
	
	public int[][] read() {
	
		int mapArray[][] = new int[18][25];
	    JSONParser parser = new JSONParser();
	
	    int i = 0;
	    int j = 0;
	    
	    try {
	            Object object;
	            try {
	                object = parser.parse(new FileReader(map + ".json"));
	                JSONObject objJSON = (JSONObject) object; 
	                
	                JSONArray arrLayer = (JSONArray) objJSON.get("layers");
	
	                	JSONArray arrData = (JSONArray) ((JSONObject) arrLayer.get(0)).get("data");
	
	                if (arrData instanceof JSONArray) {
	               System.out.println("MAP: " + arrData);
	                for(Object tileData : arrData) {
	
	                   System.out.println(tileData);
	                   if(j == 25) {
	                	   i++;
	                	   j=0;
	                   }	
						mapArray[i][j] = Integer.parseInt(Long.toString((Long)tileData));
						j++;
	                }
	                               }
	               else
	               	System.out.println("Map failed");
	                
	            } catch (org.json.simple.parser.ParseException e) {
					e.printStackTrace();
				}
	        
	
	    } catch (IOException e) {
	        e.printStackTrace();
	    } 
	    //System.out.println(mapArray);
	    return mapArray;
	}
	
	public void setMap (String newMap) {
		map = newMap;
	}
	
	public String getMap () {
		return map;
	}
}
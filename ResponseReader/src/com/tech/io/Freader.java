package com.tech.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Freader {
	
	public HashMap<String, String> attribReader() {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		ArrayList<String> al = new ArrayList<>();
		BufferedReader br;
		String currentLine=null;
		try {
			br = new BufferedReader(new java.io.FileReader("input.csv"));
			currentLine=br.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		StringTokenizer  stk= new StringTokenizer(currentLine, ",");
		int i=0;
		while(stk.hasMoreTokens()){
			if(i==0){
				hm.put("Requestid", stk.nextToken());
				i++;
			}
			if(i==1){
				hm.put("userName", stk.nextToken());
				i++;
			}
			if(i==2){
				hm.put("dimObjectType", stk.nextToken());
				i++;
			}
			if(i==3){
				hm.put("dimObjectId", stk.nextToken());
				i++;
			}
			if(i==4){
				hm.put("orderName", stk.nextToken());
				i++;
			}
			if(i==5){
				hm.put("plannedCompDate", stk.nextToken());
				i++;
			}
			if(i==6){
				hm.put("numberLow", stk.nextToken());
				i++;
			}
			if(i==7){
				hm.put("numberHigh", stk.nextToken());
				i++;
			}
			
		}
		return hm;
	}

}

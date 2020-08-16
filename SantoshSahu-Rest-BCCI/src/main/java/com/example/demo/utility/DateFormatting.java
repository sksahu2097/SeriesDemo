package com.example.demo.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatting {
	
	private final static SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date parseDate(String date) throws Exception{
		return DateFormat.parse(date);		
	}
	
}

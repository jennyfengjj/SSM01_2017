package com.qst.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	String datePattern;
	
	public DateFormatter(String datePattern){
		this.datePattern=datePattern;
	}
	@Override
	public String print(Date date, Locale arg1) {
		if(date!=null){
			String datestr = new SimpleDateFormat(datePattern).format(date);
			System.out.println(datestr);
			return datestr;
		}
		return null;
	}

	@Override
	public Date parse(String source, Locale arg1) throws ParseException {
		if(!"".equals(source) && source!=null)
			return new SimpleDateFormat(datePattern).parse(source);
		return null;
	}

}

package de.uhh.l2g.plugins.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SyntaxManager {

	public static boolean isL2gFile(String fileName){
		boolean isL2gFile=false;
		fileName = replaceIllegalFilenameCharacters(fileName);
		//pick file container
		String container = fileName.split("\\.")[fileName.split("\\.").length-1];
		
		String suffix = fileName.split("\\."+container)[0];
		
		String[] parameter = suffix.split("\\_");
		
		// the parameter array length has to be 4,
		// if not -> this is not l2go upload
		
		String l2gDate = parameter[2]+"_"+parameter[3];
		
		if (parameter.length == 4 && isL2gDate(l2gDate)){
			
			isL2gFile=true;
		}
		return isL2gFile;
	}
	
	public static String replaceIllegalFilenameCharacters(String input){
		return input.replaceAll("[^a-zA-Z0-9\\._-]+", "");
	}

	public static boolean isL2gDate(String input) {
		boolean isL2gDate = false;
        
        // xxxx-xx-xx_xx-xx
        Pattern p = Pattern.compile("\\d{4}\\-\\d{2}\\-\\d{2}\\_\\d{2}\\-\\d{2}");
        Matcher m = p.matcher(input);
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
        df.setLenient( false );
        
        if ( input.length() == 16 && m.find() ) {
        	try {
        		Date d1 = df.parse(input);
        		df.format(d1);
        		isL2gDate = true;
        	} catch ( ParseException e ) {
        		System.out.println(e);
        	} 
        }
        
		return isL2gDate;
	}
	
	
	
	
}

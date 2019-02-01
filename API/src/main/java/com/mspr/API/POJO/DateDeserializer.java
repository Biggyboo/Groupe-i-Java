package com.mspr.API.POJO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@SuppressWarnings("serial")
public class DateDeserializer extends JsonDeserializer<Date>{

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormater(jsonParser.getText() , "yyyy-MM-dd" , "MMM dd, yyyy hh:mm:ss a"); 
        try{
            return sdf.parse(date);
        }catch(ParseException e){
            throw new RuntimeException(e);
        }
    }

    public static String dateFormater(String dateFromJSON, String expectedFormat, String oldFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
        Date date = null;
        String convertedDate = null;
        try {
            date = dateFormat.parse(dateFromJSON);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(expectedFormat);
            convertedDate = simpleDateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return convertedDate;
    }

}
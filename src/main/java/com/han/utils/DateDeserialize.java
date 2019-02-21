package com.han.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserialize extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
        String date=p.getText();
        if (!"".equals(date)){
            try {
                return format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

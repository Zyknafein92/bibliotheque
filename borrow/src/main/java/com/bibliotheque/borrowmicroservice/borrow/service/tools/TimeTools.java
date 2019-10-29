package com.bibliotheque.borrowmicroservice.borrow.service.tools;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class TimeTools {

    public static Date addDays(Date date, int days) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = date.toString();
        Date dateT = sdf.parse(dateInString);

        Calendar cal = Calendar.getInstance();
        cal.setTime(dateT);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}

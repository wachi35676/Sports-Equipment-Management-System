package project.sportsequipmentmanagementsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DBTestMain {
    public static void main(String[] args) {

        DBHandler DBHANDLER =  new DBHandler();
        DBHANDLER.connectDB();
        DBHANDLER.getDefaulters();

    }
}

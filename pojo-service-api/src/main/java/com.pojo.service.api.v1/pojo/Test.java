package com.pojo.service.api.v1.pojo;

import org.joda.time.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by virmanv on 26/09/2016 October.
 */
public class Test {
    public static void main(String args[]){

//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = "[{\"name\": \"apple\",\"age\": \"1\"},{\"name\": \"banana\",\"age\": \"1\"}]";
//
//        //map json to student
//        try {
//            List<Student> student = mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, Student.class));
//            System.out.println(student);
//            mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
//            jsonString = mapper.writeValueAsString(student);
//            System.out.println(jsonString);
//
//        }
//        catch (JsonParseException e) { e.printStackTrace(); }
//        catch (JsonMappingException e) { e.printStackTrace(); }
//        catch (IOException e) { e.printStackTrace(); }
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(sdf.format(cal.getTime()));
        String dateStart = sdf.format(cal.getTime());
        String dateStop = "23/01/2017 10:31:48";

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);

            System.out.print(Days.daysBetween(dt1, dt2).getDays() + " days, ");
            System.out.print(Hours.hoursBetween(dt1, dt2).getHours() % 24 + " hours, ");
            System.out.print(Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 + " minutes, ");
            System.out.print(Seconds.secondsBetween(dt1, dt2).getSeconds() % 60 + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }


//        String dateStart = "21/01/17 17:11:12";
//        try {
//
//
//            String date=sdf.format(cal.getTime());
//            Date d1=null;
//            Date d2= null;
//            d1 = sdf.parse(dateStart);
//            d2 = sdf.parse(date);
//
//            //in milliseconds
//            long diff = d1.getTime() - d2.getTime();
//            System.out.println(diff);
//            long diffSeconds = diff / 1000 % 60;
//            long diffMinutes = diff / (60 * 1000) % 60;
//            long diffHours = diff / (60 * 60 * 1000) % 24;
//            long diffDays = diff / (24 * 60 * 60 * 1000);
//86400000
//            System.out.print(diffDays + " days, ");
//            System.out.print(diffHours + " hours, ");
//            System.out.print(diffMinutes + " minutes, ");
//            System.out.print(diffSeconds + " seconds.");

//            long d1=sdf.parse(date).getTime();
//
//            long d2=sdf.parse(dateStart).getTime();
//            long diff=d1-d2;
//            long diffSeconds = diff / 1000;
//            long diffMinutes = diff / (60 * 1000);
//            long diffHours = diff / (60 * 60 * 1000);
//            long diffDays = diff / (24 * 60 * 60 * 1000);
//            System.out.println("\nThe Date Different Example");
//            System.out.println("Time in milliseconds: " + diff + " milliseconds.");
//            System.out.println("Time in seconds: " + diffSeconds + " seconds.");
//            System.out.println("Time in minutes: " + diffMinutes + " minutes.");
//            System.out.println("Time in hours: " + diffHours + " hours.");
//            System.out.println("Time in days: " + diffDays + " days.");

//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        long milliseconds1 = calendar1.getTimeInMillis();
//        long milliseconds2 = calendar2.getTimeInMillis();
//        long diff = milliseconds2 - milliseconds1;
//        long diffSeconds = diff / 1000;
//        long diffMinutes = diff / (60 * 1000);
//        long diffHours = diff / (60 * 60 * 1000);
//        long diffDays = diff / (24 * 60 * 60 * 1000);
//        System.out.println("\nThe Date Different Example");
//        System.out.println("Time in milliseconds: " + diff + " milliseconds.");
//        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
//        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
//        System.out.println("Time in hours: " + diffHours + " hours.");
//        System.out.println("Time in days: " + diffDays + " days.");

    }
}
class Student {
    private String name;
    private int age;

    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "Student [ name: "+name+", age: "+ age+ " ]";
    }
}
package com.lee.probuf;

import java.lang.invoke.ConstantCallSite;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Date d3;
    public static void main(String[] args) {
	    System.out.println("Hello world");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = sdf.parse("2017-08-17T11:11:43.8366667".replace("T"," "));
            System.out.println(d);
            TestType t = TestType.User;
            System.out.println(t.toString());

            System.out.println(String.format("the time of long now is :%d", new Date().getTime()));

            Date d1 = sdf.parse("2017-08-29 12:00:00");
            Date d2 = new Date();
            long lt = (d2.getTime() - d1.getTime());
            System.out.println(String.format("%dms,%ds,%fm,%dh",lt,lt/1000,lt*1.0/(1000*60),lt/(1000*60*60)));
            System.out.println(d3);

            System.out.println("=========================");
            Date dd = new Date();
            for(int i = 0; i < 20; ++i) {
                dd.setTime(dd.getTime() + 1000 * 60 * 5);
                System.out.println(sdf.format(dd));
            }

            long a = Long.parseLong("00005");
            System.out.println(a);

            queueTest();

            dateTest();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static void queueTest(){
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    static void dateTest(){
        System.out.println("=======================");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTest dateTest = new DateTest();
        try {
            Date dt = sdf.parse("2017-08-02 01:00:12");
            String str = dateTest.dateInfo(dt);
            System.out.println(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public enum TestType{
        Auth,
        User,
        Size
    }

    private static final class DateTest{
        public String dateToString(Date date, String format){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }

        public String dateInfo(Date date){
            int offset = Calendar.getInstance().getTimeZone().getRawOffset();
            long today = (System.currentTimeMillis()+offset) / 86400000;
            long start = (date.getTime() + offset) / 86400000;
            long intervalTime = start - today;
            if(intervalTime == 0){
                return dateToString(date,"HH:mm");
            }else if(intervalTime == -1){
                return "昨天";
            }else if(intervalTime == -2){
                return "前天";
            }else if(intervalTime < 0 && intervalTime > -7){
                return "上周";
            }else{
                return dateToString(date,"MM-dd");
            }
        }
    }
}

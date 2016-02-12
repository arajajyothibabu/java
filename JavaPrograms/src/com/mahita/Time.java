package com.mahita;

/**
 * Created by Araja Jyothi Babu on 12-02-2016.
 */
public class Time{
    int hours;
    int minutes;
    int seconds;
    Time(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    void setHours(int hours){
        this.hours = hours;
    }
    void setMinutes(int minutes){
        this.minutes = minutes;
    }
    void setSeconds(int seconds){
        this.seconds = seconds;
    }
    void setTime(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    void getTime(){
        System.out.println(hours + " Hours::" + minutes + " Minutes::" + seconds + " Seconds");
    }
    void resetTime(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    public static void main(String args[]) throws Exception{
        Time time = new Time(12,12,12);
        time.getTime();
        time.setTime(10,10,10);
        time.getTime();
    }
}

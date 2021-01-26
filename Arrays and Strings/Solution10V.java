/**
 * Problem statement:
 * Given two integers, an hour and a minute, write a function
 * to calculate the angle between the two hands on a clock representing that time.
 */

public class Solution10V {

    private static float getHourAngle(int hour, int min) {
       return (hour * (360/12)) + ((min * 360)/(12*60));
    }

    private static float getMinuteAngle(int min) {
        return min * (360/60);
    }

    private static float calculateAngle(int hour, int min) {
        if (hour < 0 || hour > 24 || min > 60 || min < 0) {
        System.out.println("Invalid input");
        return 0;
        }

        if (hour > 12) {
            hour -= 12;
        }

        if(hour == 12) {
            hour = 0;
        }

        if (min == 60) {
            min = 0;
            hour += 1;
        }

        float angle = Math.abs(getHourAngle(hour, min) - getMinuteAngle(min));
        return Math.min(360-angle, angle);
    }

    public static void main(String args[]) {
        System.out.println(calculateAngle(12, 0));
        System.out.println(calculateAngle(6, 0));
        System.out.println(calculateAngle(5, 30));
        System.out.println(calculateAngle(3, 15));
        System.out.println(calculateAngle(9, 15));
    }
}
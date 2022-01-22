package lt.codeacademy;

public class Task15 {
    public static void main(String[] args) {
        int minutes = 1000000;
        int minuterPerDay = 24*60;
        int daysPerYear = 365;

        int days = minutes/minuterPerDay;
        int years = days/daysPerYear;
        int remainingMinutes = minutes % minuterPerDay;
        days %= daysPerYear;

        System.out.printf("%d converts to %d years, %d days and %d minutes",minutes, years, days, remainingMinutes);
    }
}

package conspect.dates;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateLocalTimeLocalDateTime {
    public static void main(String[] args) {
        workLocalDate();
        workLocalTime();
        workLocalDateTime();

    }

    private static void workLocalDate() {
        System.out.println("----- workLocalDate()-----");
        LocalDate now = LocalDate.now();
        LocalDate date1 = LocalDate.of(2018, 04, 02);
        LocalDate date2 = LocalDate.parse("2019-05-01");

        System.out.println("now = " + now);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
        boolean leapYear = LocalDate.now().isLeapYear();
        System.out.println("plusDays 1 = " + tomorrow);
        System.out.println("minus MONTHS = " + previousMonthSameDay);
        System.out.println("getDayOfWeek = " + sunday);
        System.out.println("getDayOfMonth = " + twelve);
        System.out.println("isLeapYear = " + leapYear);

        boolean isBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));
        System.out.println("2016-06-12 isBefore 2016-06-11 = " + isBefore);

        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));
        System.out.println("2016-06-12 isAfter 2016-06-11 = " + isAfter);

        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
                .with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("atStartOfDay = " + beginningOfDay);
        System.out.println("firstDayOfMonth = " + firstDayOfMonth);
    }

    private static void workLocalTime() {
        System.out.println("----- workLocalTime()-----");
        LocalTime now = LocalTime.now();
        LocalTime time1 = LocalTime.parse("06:30");
        LocalTime time2 = LocalTime.of(6, 30);

        System.out.println("now = " + now);
        System.out.println("time1 = " + time1);
        System.out.println("time2 = " + time2);

        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        int six = LocalTime.parse("06:30").getHour();
        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        LocalTime maxTime = LocalTime.MAX;

        System.out.println("plus 1 HOURS = " + sevenThirty);
        System.out.println("getHour = " + six);
        System.out.println("isbefore = " + isbefore);
        System.out.println("maxTime = " + maxTime);
    }

    private static void workLocalDateTime() {
        System.out.println("----- workLocalDateTime()-----");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
        LocalDateTime dateTime2 = LocalDateTime.parse("2015-02-20T06:30:00");

        System.out.println("now = " + now);
        System.out.println("dateTime1 = " + dateTime1);
        System.out.println("dateTime2 = " + dateTime2);


    }
}

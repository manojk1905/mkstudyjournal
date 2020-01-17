package features.java8;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateTimeApiChanges {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
        System.out.println(" Current date ::" + date);

        LocalDate nextMonday = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Date on upcoming monday : " + nextMonday);

        Period period = Period.between(nextMonday, date);
        System.out.println("Gap on next monday "+period);

        System.out.println("Current time :: " + LocalTime.now());
        Duration fiveHours = Duration.ofHours(2);

        LocalTime time = LocalTime.now().plus(fiveHours);
        System.out.println("Time after 2 hours :: " + time);

        LocalDateTime current = LocalDateTime.now();
        System.out.println("Current date-time : " +current);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Formatted Date " +current.format(format));
	}

}

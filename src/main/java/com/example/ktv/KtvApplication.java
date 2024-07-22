package com.example.ktv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@SpringBootApplication
public class KtvApplication {

	public static void main(String[] args) {
		// Create a LocalDateTime object for a specific time
		LocalDateTime localDateTime = LocalDateTime.now();
		// Specify the time zone for Cambodia
		ZoneId cambodiaZoneId = ZoneId.systemDefault();

		// Create a ZonedDateTime in Cambodia time zone
		ZonedDateTime cambodiaDateTime = localDateTime.atZone(cambodiaZoneId);

		// Convert the Cambodia time to New York time zone
		ZoneId newYorkZoneId = ZoneId.of("America/New_York");
		ZonedDateTime newYorkDateTime = cambodiaDateTime.withZoneSameInstant(newYorkZoneId);

		// Print the results
		System.out.println("LocalDateTime in Cambodia: " + localDateTime);
		System.out.println("ZonedDateTime in Cambodia: " + cambodiaDateTime);
		System.out.println("ZonedDateTime in New York: " + newYorkDateTime);
		SpringApplication.run(KtvApplication.class, args);
	}

}

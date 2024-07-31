package date_time

import kotlinx.datetime.TimeZone

val cityTimeZone = listOf(
    City("Berlin", TimeZone.of("Europe/Berlin")),
    City("London", TimeZone.of("Europe/London")),
    City("New York", TimeZone.of("America/New_York")),
    City("Los Angeles", TimeZone.of("America/Los_Angeles")),
    City("Tokyo", TimeZone.of("Asia/Tokyo")),
    City("Sydney", TimeZone.of("Australia/Sydney")),
)
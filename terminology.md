# Terminology

| Term           | What it means                                                | Example                                   | 
|----------------|--------------------------------------------------------------|-------------------------------------------|
| UTC            | Coordinated Universal Time  the global base time (no daylight saving) | 2025-04-20T14:00:00Z                      |
| Time Zone      | A region's standard time rules (offsets + DST)| Europe/Stockholm, Asia/Kolkata            |
| Offset         | Fixed difference from UTC at a given moment| +02:00, +05:30                            |
| Z              | Means Zulu time (UTC)  used in ISO 8601| 2025-04-20T14:00:00Z                      |
| DST            | Daylight Saving Time  forward/back by 1 hour in summer/winter| CET becomes CEST in summer                |
| Epoch          | The base reference point: 1970-01-01T00:00:00Z| Instant.now().toEpochMilli()              |
| Local time     | The date/time as seen by the user in a region| 2025-04-20T16:00 in Stockholm             |
| Instant        | A timestamp in UTC (machine time, absolute)| 2025-04-20T14:00:00Z                      |
| LocalDateTime  | Date + time with no time zone info| 2025-04-20T16:00                          |
| ZonedDateTime  | Date + time + zone (can handle DST, comparisons, etc.)| 2025-04-20T16:00+02:00[Europe/Stockholm]  |

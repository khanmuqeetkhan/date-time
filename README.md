# Date time
You are starting on a new application, it has no requirement to support multiple zones. 
But every application has some date time handling. It might be the following:
- Date of creation or update.
- Comparing dates. 

Finally even though there is no formal requirement today, the application should be 
scalable in the future.

The first thing that comes to mind is to start using LocalDate or LocalDateTime.

Note: If you want to understand some terminology before starting, 
then [check this out](./terminology.md).

### LocalDateTime (LocalDate) vs Instant.

LocalDateTime: 
- A date and time without timezone.
- Can be misleading across time zones.
- More readable (2025-04-20T14:15).

Instant:
- A moment on the timeline in UTC.
- Reliable global comparison.
- Not as readable (2025-04-20T12:15:00Z).

#### Analogy

Think of:
- Instant = GPS coordinates (exact, always valid)
- LocalDateTime = a clock without a location (shows 2 PM, but where?)
- ZonedDateTime = a clock in a specific city (e.g., “2 PM in Stockholm”)

```
// From Instant to LocalDateTime (in a specific zone)
Instant instant = Instant.now();
LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("Europe/Stockholm"));

// From LocalDateTime + ZoneId to Instant
Instant backToInstant = localDateTime.atZone(ZoneId.of("Europe/Stockholm")).toInstant();
```

#### Summary
By now you probably have understood why to use Instant. Let's move forward to see if 
we should directly use Instant.now() -> or should consider using Clock.

### Clock

What's the value of Clock? 
Using Clock makes your code testable, reliable, and less flaky.

| Without Clock                   | With Clock                    |
|---------------------------------|-------------------------------|
| Uses system time (hard to test) | Time is controlled (testable) |
| Test can randomly break         | Tests are deterministic       |
| Refactoring risk is higher      | Safe, mockable, clean code    |

Why you need Clock for testability?
```
Instant.now() -> it’s hard to test because it gives the real current time every time.

Instant.now(clock) -> you can inject a fixed clock and write predictable and repeatable tests.
```

### Common date format & parsing

`yyyyMMdd'T'HH:mm:ssZ -> 20250419T14:30:00Z`
- Z at the end means it’s in UTC time — the "Z" stands for Zulu, which is the military name for UTC.

What should you do when external system sends ISO strings with Z?
You should never parse that into LocalDateTime.

```
String input = "20250419T14:30:00Z";

Instant instant = Instant.parse(input); // safe
```



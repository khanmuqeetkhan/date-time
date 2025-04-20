package se.maha.datetime.domain;

import java.time.Clock;
import java.time.Instant;

public class DateTimeService {

    private final Clock clock;

    public DateTimeService(Clock clock) {
        this.clock = clock;
    }

    public Instant now() {
        return Instant.now(clock);
    }
}
package se.maha.datetime.domain;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

//@Entity
public class Task {

    private Long id;

    private final Instant createdAt;
    private final Instant updatedAt;

    public Task(Instant createdAt) {
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean isCreatedMoreThanAWeekAgo(Instant referenceTime) {
        Instant sevenDaysAgo = referenceTime.minus(7, ChronoUnit.DAYS);
        return this.createdAt.isBefore(sevenDaysAgo);
    }
}
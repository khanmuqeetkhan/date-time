package se.maha.datetime.domain;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void isCreatedMoreThanAWeekAgo() {
        Instant fixedInstant = Instant.parse("2025-04-20T10:00:00Z");
        Task task = new Task(fixedInstant);

        Instant today = Instant.parse("2025-04-28T10:00:00Z");
        assertTrue(task.isCreatedMoreThanAWeekAgo(today));
    }


}
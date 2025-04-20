package se.maha.datetime.domain;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldCreateTaskWithFixedInstant() {
        // Arrange
        Instant fixedInstant = Instant.parse("2025-04-20T10:00:00Z");
        Clock fixedClock = Clock.fixed(fixedInstant, ZoneOffset.UTC);
        DateTimeService dateTimeService = new DateTimeService(fixedClock);

        TaskService taskService = new TaskService(dateTimeService);

        Task task = taskService.createTask();

        assertEquals(fixedInstant, task.getCreatedAt());
    }

}
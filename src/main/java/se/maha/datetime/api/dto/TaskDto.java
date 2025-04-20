package se.maha.datetime.api.dto;

import java.time.Instant;

public record TaskDto(Instant createdAt, Instant updatedAt) {}

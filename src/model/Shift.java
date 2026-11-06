package model;

import exception.InvalidShiftException;

import java.time.Duration;
import java.time.LocalDateTime;

public class Shift {
    LocalDateTime start;
    LocalDateTime end;
    Duration workedHours;
    Duration breakDuration;


    public Shift(LocalDateTime start, LocalDateTime end, Duration breakDuration) throws InvalidShiftException {
        if (start.isAfter(end)) {
            throw new InvalidShiftException("A saída deve ser depois da entrada");
        }

        this.start = start;
        this.end = end;
        this.breakDuration = breakDuration;
    }

    public Duration calculateWorkedHours() {
        workedHours = Duration.between(start, end).minus(breakDuration); // Time at the company minus the break
        System.out.println(workedHours);
        return workedHours;
    }
}

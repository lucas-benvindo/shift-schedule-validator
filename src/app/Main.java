package app;

import exception.InvalidShiftException;
import model.Shift;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Esperado: PT8H");
        try {
            Shift shift = new Shift(LocalDateTime.of(2026,11,5,8,0), LocalDateTime.of(2026, 11,5,17,0), Duration.ofHours(1));
            shift.calculateWorkedHours();
        } catch (InvalidShiftException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Esperado: A saída deve ser depois da entrada ");
        try {
            Shift shift = new Shift(LocalDateTime.of(2026, 11,5,17,0), LocalDateTime.of(2026,11,5,8,0), Duration.ofHours(1));
            shift.calculateWorkedHours();
        } catch (InvalidShiftException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Esperado: Turno Longo Demais");
        try {
            Shift shift = new Shift(LocalDateTime.of(2026, 1,5,17,0), LocalDateTime.of(2026,12,5,8,0), Duration.ofHours(1));
            shift.calculateWorkedHours();
        } catch (InvalidShiftException e) {
            System.out.println(e.getMessage());
        }
    }
}

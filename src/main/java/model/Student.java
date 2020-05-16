package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;

    private String firstName;
    private String lastName;

    private double wzrost;
    private int age;

    private boolean alive; // nie isAlive

    public double getHeight() {
       return this.wzrost;
    }
    // lombok jeśli wygeneruje metodę na podstawie pola isAlive, to nazywać się będzie "isIsAlive"
    // isAlive
}
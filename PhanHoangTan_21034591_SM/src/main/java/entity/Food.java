package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "food")
public class Food extends Item {
    @Enumerated(EnumType.STRING)
    private Type type;
    private int preparationTime;
    private int servingTime;


    public Food(String id, String name, Double price, String description, Boolean onSpecial, Type type, int preparationTime, int servingTime) {
        super(id, name, price, description, onSpecial);
        this.type = type;
        this.preparationTime = preparationTime;
        this.servingTime = servingTime;
    }

    public Food() {
    }
}
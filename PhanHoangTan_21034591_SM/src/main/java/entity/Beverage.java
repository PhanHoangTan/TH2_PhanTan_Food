package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "beverage")
public class Beverage extends Item {
    @Enumerated(EnumType.STRING)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    public Beverage(String id, String name, Double price, String description, Boolean onSpecial, Size size) {
        super(id, name, price, description, onSpecial);
        this.size = size;
    }

    public Beverage() {
    }
}
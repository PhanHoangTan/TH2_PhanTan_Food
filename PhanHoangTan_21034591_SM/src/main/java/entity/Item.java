package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "item")

@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Item implements Serializable {
    private static final long serialVersionUID = -5023340962065349410L;
    @Id
    @Column(name = "item_id", nullable = false)
    protected String id;


    protected String name;
    protected Double price;
    protected String description;
    protected Boolean onSpecial;

    @ManyToMany
    @JoinTable(
            name = "made_of",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    protected Set<Ingredient> ingredients;

    public Item(String id, String name, Double price, String description, Boolean onSpecial) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.onSpecial = onSpecial;
    }

    public Item() {
    }
}
package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable{
    private static final long serialVersionUID = -5023340962065349410L;
    @Id
    @Column(name = "ingredient_id", nullable = false)
    private String id;
    private String name;
    private String url;
    private String unit;
    private double price;
    private double quantity;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    @ManyToMany
    @JoinTable(
            name = "made_of",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private Set<Item> items;


    public Ingredient(String id, String name, String url, String unit, double price, double quantity, LocalDate manufacturingDate, LocalDate expiryDate) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;

    }

    public Ingredient() {
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", manufacturingDate=" + manufacturingDate +
                ", expiryDate=" + expiryDate +

                '}';
    }
}
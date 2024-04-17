package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {
    private static final long serialVersionUID = -5023340962065349410L;
    @Id
    @Column(name = "supplier_id", nullable = false)
    private String id;

    private String name;
    private String url;
    private String address;
    private String phone;
    private String email;
    @ManyToMany
    @JoinTable(
            name = "supply_by",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Set<Ingredient> ingredients;

    @OneToMany(mappedBy = "supplier")
    private Set<Beverage> beverages;

    public Supplier(String id, String name, String url, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Supplier() {
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
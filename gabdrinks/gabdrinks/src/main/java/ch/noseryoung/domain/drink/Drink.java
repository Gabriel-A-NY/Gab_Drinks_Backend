package ch.noseryoung.domain.drink;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drink")
@Getter
@Setter
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    public Drink(int id, String product_name, float price, String description) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
    }

    public Drink() {}
}

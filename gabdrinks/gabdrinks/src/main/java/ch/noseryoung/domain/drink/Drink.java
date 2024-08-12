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
    private String pages;

    @Column(name = "price")
    private float price;

    @Column(name = "description")
    private String description;

    public Drink(String description, float price, String pages, int id) {
        this.description = description;
        this.price = price;
        this.pages = pages;
        this.id = id;
    }
}

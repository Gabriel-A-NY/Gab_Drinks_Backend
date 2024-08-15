package ch.noseryoung.domain.drink;

import jakarta.persistence.*;
import lombok.*;

@Entity
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

    @Column(name = "image_link")
    private String image_link;
}

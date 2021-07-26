package br.com.mercadinho.Mercadinho.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(length = 255, nullable = false)
    private String description;
    @Column(length = 255, nullable = false)
    private String provider;
    @Column(nullable = false)
    private Double price;
}

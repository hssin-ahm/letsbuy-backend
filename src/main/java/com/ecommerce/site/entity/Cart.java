package com.ecommerce.site.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private User user;

    private int quantity;


}

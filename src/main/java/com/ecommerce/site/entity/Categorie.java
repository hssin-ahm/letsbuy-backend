package com.ecommerce.site.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nom;
	String description;
	@OneToMany(mappedBy = "categorie")//, cascade = CascadeType.ALL)
	@JsonIgnore
	List<Produit> produits;



}

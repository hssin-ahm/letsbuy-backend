package com.ecommerce.site.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Size(min = 3, max = 30)
	private String name;
	private float prix;
	private int quantite;
	private String imgName;
	private String description;

//
//	@CreationTimestamp
//	private Date dateCreated;
//
//	@UpdateTimestamp
//	private Date lastUpdated;


	@ManyToOne
	Categorie categorie;

}

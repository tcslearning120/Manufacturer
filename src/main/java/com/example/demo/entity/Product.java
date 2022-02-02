package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="PDCT")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer productId;
	@NotBlank
	@NotNull
	@Size(max = 50)
private  String productName;
	@NotBlank
	@NotNull
	@Size(max = 50)
private String quantityInHand;
	@OneToMany(mappedBy = "product",cascade= CascadeType.ALL,fetch =FetchType.LAZY )
	private List<Component >components;
	public Product() {}
	
	public Product(@Size @Pattern(regexp = "^[0-9]*$") Integer productId,
			@NotBlank @NotNull @Size(max = 50) String productName,
			@NotBlank @NotNull @Size(max = 50) String quantityInHand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantityInHand = quantityInHand;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantityInHand() {
		return quantityInHand;
	}
	public void setQuantityInHand(String quantityInHand) {
		this.quantityInHand = quantityInHand;
	}
	
}

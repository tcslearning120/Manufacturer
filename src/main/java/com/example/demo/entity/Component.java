package com.example.demo.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table(name="Commponents")
public class Component {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer componentId;
	@NotBlank
	@NotNull
	@Size(max = 25)
private  String componentName;
	@NotBlank
	@NotNull
	@Size(max = 20)
private  String componentDescription;
	@NotBlank
	@NotNull
	@Size(max = 20)
private  String componentSupplier;
	@NotBlank
	@NotNull
	@Size(max = 20)
private  String componentProductUsed;
	@ManyToMany(fetch =FetchType.LAZY ,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "Component_Supplier", joinColumns = {
			@JoinColumn(name = "componentId", referencedColumnName = "componentId") }, inverseJoinColumns = {
					@JoinColumn(name = "supplierId", referencedColumnName = " supplierId") })
	private Set<Supplier> supplier = new  HashSet<>();
	public Component() {}
	
   

	public Component(Integer componentId, @NotBlank @NotNull @Size(max = 25) String componentName,
			@NotBlank @NotNull @Size(max = 20) String componentDescription,
			@NotBlank @NotNull @Size(max = 20) String componentSupplier,
			@NotBlank @NotNull @Size(max = 20) String componentProductUsed, Set<Supplier> supplier, Product product) {
		super();
		this.componentId = componentId;
		this.componentName = componentName;
		this.componentDescription = componentDescription;
		this.componentSupplier = componentSupplier;
		this.componentProductUsed = componentProductUsed;
		this.supplier = supplier;
		this.product = product;
	}



	@ManyToOne(targetEntity=Product.class,fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="product_id",referencedColumnName = "productId")
private Product product;
	public Integer getComponentId() {
		return componentId;
	}
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentDescription() {
		return componentDescription;
	}
	public void setComponentDescription(String componentDescription) {
		this.componentDescription = componentDescription;
	}
	public String getComponentSupplier() {
		return componentSupplier;
	}
	public void setComponentSupplier(String componentSupplier) {
		this.componentSupplier = componentSupplier;
	}
	public String getComponentProductUsed() {
		return componentProductUsed;
	}
	public void setComponentProductUsed(String componentProductUsed) {
		this.componentProductUsed = componentProductUsed;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Set<Supplier> getSupplier() {
		return supplier;
	}
	public void setSupplier(Set<Supplier> supplier) {
		this.supplier = supplier;
	}
	
	
	
}

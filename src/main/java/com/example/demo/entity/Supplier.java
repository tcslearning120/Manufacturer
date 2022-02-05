package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Spply")
public class Supplier {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer supplierId;
	@NotBlank
	@NotNull
	@Size(max = 50)
	@Pattern(regexp = "[a-zA-Z]*$")
	private String supplierName;
	@NotNull
	@Size(max = 50)
	@Pattern(regexp = "[a-zA-Z]*$")
	private String supplierComponentDescription;
	@ManyToMany(mappedBy ="supplier",fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	
	private Set<Component> component = new HashSet<>();

	public Supplier() {
	}

	public Supplier(Integer supplierId,
			@NotBlank @NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]*$") String supplierName,
			@NotNull @Size(max = 50) @Pattern(regexp = "[a-zA-Z]*$") String supplierComponentDescription,
			Set<Component> component) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierComponentDescription = supplierComponentDescription;
		this.component = component;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	

	public String getSupplierComponentDescription() {
		return supplierComponentDescription;
	}

	public void setSupplierComponentDescription(String supplierComponentDescription) {
		this.supplierComponentDescription = supplierComponentDescription;
	}

	public Set<Component> getComponent() {
		return component;
	}

	public void setComponent(Set<Component> component) {
		this.component = component;
	}

}

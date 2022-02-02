package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table(name="CMPT")
public class Component {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public Component() {}
	public Component(@Size @Pattern(regexp = "^[0-9]*$") Integer componentId,
			@NotBlank @NotNull @Size(max = 25) String componentName,
			@NotBlank @NotNull @Size(max = 20) String componentDescription,
			@NotBlank @NotNull @Size(max = 20) String componentSupplier,
			@NotBlank @NotNull @Size(max = 20) String componentProductUsed) {
		super();
		this.componentId = componentId;
		this.componentName = componentName;
		this.componentDescription = componentDescription;
		this.componentSupplier = componentSupplier;
		this.componentProductUsed = componentProductUsed;
	}
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="product_id_fk",referencedColumnName = "productId")
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
	
}

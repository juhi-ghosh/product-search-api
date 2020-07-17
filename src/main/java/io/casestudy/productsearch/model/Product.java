package io.casestudy.productsearch.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 
 * @author jghosh
 *
 */
@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "SKU", unique=true)
	private String sku;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="product",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Category> category;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="product",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<AttributeValue> attributeValue;

	public Product() {
		super();
	}

	public Product(Integer id, String name, String description, String sku, Integer quantity, Set<Category> category,
			Set<AttributeValue> attributeValue) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sku = sku;
		this.quantity = quantity;
		this.category = category;
		this.attributeValue = attributeValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Set<AttributeValue> getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(Set<AttributeValue> attributeValue) {
		this.attributeValue = attributeValue;
	}

	
}

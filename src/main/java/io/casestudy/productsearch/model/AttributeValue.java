package io.casestudy.productsearch.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author jghosh
 *
 */
@Entity
@Table(name = "ATTRIBUTE_VALUE")
public class AttributeValue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ATTRIBUTE_VALUE_ID")
	private Integer id;

	@Column(name = "DATA")
	private String data;

	@Column(name = "IS_ACTIVE")
	private Boolean is_active;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ATTRIBUTE_ID")
	@JsonBackReference
	private Attribute attribute;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRODUCT_ID")
	@JsonBackReference
	private Product product;

	public AttributeValue() {
		super();
	}

	public AttributeValue(Integer id, String data, boolean is_active, Attribute attribute, Product product) {
		super();
		this.id = id;
		this.data = data;
		this.is_active = is_active;
		this.product = product;
		this.attribute = attribute;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

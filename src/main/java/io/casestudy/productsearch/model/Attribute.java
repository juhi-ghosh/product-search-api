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
@Table(name = "ATTRIBUTE")
public class Attribute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ATTRIBUTE_ID")
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "IS_ACTIVE")
	private Boolean is_active;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="attribute",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<AttributeValue> attributeValue;

	public Attribute() {
		super();
	}

	public Attribute(Integer id, String name, Boolean is_active, Set<AttributeValue> attributeValue) {
		super();
		this.id = id;
		this.name = name;
		this.is_active = is_active;
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

	public Boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}	
	
	public Set<AttributeValue> getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(Set<AttributeValue> attributeValue) {
		this.attributeValue = attributeValue;
	}
}

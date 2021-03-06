package com.niit.shoppingbackendmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Supplier")
@Component
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")

	private int id;
	private String name;
	private String address;
	
	
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
